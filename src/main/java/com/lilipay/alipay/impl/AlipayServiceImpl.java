package com.lilipay.alipay.impl;

import com.lilipay.alipay.AlipayService;
import com.lilipay.alipay.domain.*;
import com.lilipay.alipay.entity.AlipayAppEntity;
import com.lilipay.alipay.gateway.AlipayGateService;
import com.lilipay.alipay.gateway.domain.*;
import com.lilipay.alipay.mapper.AlipayAppEntityMapper;
import com.lilipay.common.AlipayStatus;
import com.lilipay.common.Response;
import com.lilipay.common.ResponseUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AlipayServiceImpl implements AlipayService {

    private static final Logger logger = LogManager.getLogger( AlipayServiceImpl.class );

    @Value( "alipay.appId" )
    private String appId;

    private static final Map<String, String> statusMap;

    static {
        statusMap = new HashMap<>();
        statusMap.put( "WAIT_BUYER_PAY", "PAYING" );
        statusMap.put( "TRADE_CLOSED", "FAIL" );
        statusMap.put( "TRADE_SUCCESS", "SUCCESS" );
        statusMap.put( "TRADE_FINISHED", "FAIL" );
    }

    @Resource
    private AlipayAppEntityMapper alipayAppEntityMapper;

    @Resource
    private AlipayGateService alipayGatewayService;

    @Override
    public Response<AlipayAppPayOrderInfo> appPay( AlipayAppPayInput alipayAppPayRequest ) {
        // 保存存求
        AlipayAppEntity alipayAppEntity = new AlipayAppEntity();
        alipayAppEntity.setRequestNo( alipayAppPayRequest.getRequestNo() );
        alipayAppEntity.setProcessNo( UUID.randomUUID().toString().replace( "-", "" ) );
        alipayAppEntity.setAppId( appId );
        alipayAppEntity.setOutTradeNo( UUID.randomUUID().toString().replace( "-", "" ) );
        alipayAppEntity.setSubject( alipayAppPayRequest.getSubject() );
        alipayAppEntity.setTotalAmount( alipayAppPayRequest.getTotalAmount() );
        alipayAppEntity.setTimeoutExpress( alipayAppPayRequest.getTimeoutExpress() );
        alipayAppEntity.setTimeExpire( alipayAppPayRequest.getTimeExpire() );
        alipayAppEntity.setStatus( AlipayStatus.PAYING );
        alipayAppEntityMapper.insertSelective( alipayAppEntity );
        //  调用网关
        AlipayAppPayGateInput appPayRequest = new AlipayAppPayGateInput();
        Response<AlipayAppPayGateOutput> response = alipayGatewayService.appPay( appPayRequest );
        if ( !response.isSuccess() ) {
            alipayAppEntity.setStatus( AlipayStatus.FAIL );
            alipayAppEntityMapper.updateByPrimaryKeySelective( alipayAppEntity );

            logger.info( "支付宝网关异常: {}", response );
            return ResponseUtils.fail( "GATEWAY_ERROR", "网关异常" );
        }
        //  调用成功
        AlipayAppPayGateOutput responseData = response.getData();
        AlipayAppPayOrderInfo alipayAppPayResult = new AlipayAppPayOrderInfo();
        alipayAppPayResult.setOrderInfo( responseData.getOrderInfo() );
        return ResponseUtils.success( alipayAppPayResult );
    }

    @Override
    public Response<AlipayAppPayTradeOutput> tradeQuery( AlipayTradeQueryInput orderQueryRequest ) {

        AlipayAppEntity alipayAppEntity = alipayAppEntityMapper.selectByRequestNo( orderQueryRequest.getRequestNo() );
        if ( alipayAppEntity == null ) {
            logger.info( "支付宝订单不存在: {}", orderQueryRequest.getRequestNo() );
            return ResponseUtils.fail( "TRADE_NOT_EXISTS", "订单不存在" ); // 上游系统需要处理该错误码
        }

        AlipayAppPayTradeOutput alipayAppPayTradeResult = buildAlipayAppPayTradeResult( orderQueryRequest.getRequestNo(), alipayAppEntity );
        return ResponseUtils.success( alipayAppPayTradeResult );
    }

    @Override
    public Response<AlipayAppPayTradeOutput> orderClose( AlipayOrderCloseInput orderCloseRequest ) {

        AlipayAppEntity alipayAppEntity = alipayAppEntityMapper.selectByRequestNo( orderCloseRequest.getRequestNo() );
        if ( alipayAppEntity == null ) {
            logger.info( "支付宝订单不存在: {}", orderCloseRequest.getRequestNo() );
            return ResponseUtils.fail( "TRADE_NOT_EXISTS", "订单不存在" ); // 上游系统需要处理该错误码
        }

        if ( AlipayStatus.FAIL.equals( alipayAppEntity.getStatus() ) || AlipayStatus.SUCCESS.equals( alipayAppEntity.getStatus() ) ) {
            logger.info( "支付宝订单不存在: {}", orderCloseRequest.getRequestNo() );
            return ResponseUtils.fail( "TRADE_IS_FINAL", "订单已终态" );
        }

        AlipayTradeQueryGateInput tradeQueryRequest = new AlipayTradeQueryGateInput();
        tradeQueryRequest.setOutTradeNo( alipayAppEntity.getOutTradeNo() );

        //  关单之前同步一次 降低关单失败概率
        Response<AlipayAppPayTradeOutput> query1Response = tradeSync( alipayAppEntity, tradeQueryRequest );
        if ( query1Response != null ) {
            return query1Response;
        }

        AlipayTradeCloseGateInput tradeCloseRequest = new AlipayTradeCloseGateInput();
        tradeCloseRequest.setOutTradeNo( tradeCloseRequest.getOutTradeNo() );
        Response<AlipayTradeCloseGateOutput> closeResponse = alipayGatewayService.tradeClose( tradeCloseRequest );
        if ( !closeResponse.isSuccess() ) {
            logger.info( "支付宝网关异常: {}", closeResponse );
            return ResponseUtils.fail( "GATEWAY_ERROR", "网关异常" );
        }

        logger.info( "订单关闭成功: {}", orderCloseRequest.getRequestNo() );
        Response<AlipayAppPayTradeOutput> query2Response = tradeSync( alipayAppEntity, tradeQueryRequest );
        if ( query2Response != null ) {
            return query2Response;
        }

        AlipayAppPayTradeOutput alipayAppPayTradeResult = buildAlipayAppPayTradeResult( alipayAppEntity.getRequestNo(), alipayAppEntity );
        return ResponseUtils.success( alipayAppPayTradeResult );
    }

    @Override
    public Response<AlipayAppPayTradeOutput> tradeSync( AlipayTradeSyncInput tradeSyncRequest ) {

        AlipayAppEntity alipayAppEntity = alipayAppEntityMapper.selectByRequestNo( tradeSyncRequest.getRequestNo() );
        if ( alipayAppEntity == null ) {
            logger.info( "支付宝订单不存在: {}", tradeSyncRequest.getRequestNo() );
            return ResponseUtils.fail( "TRADE_NOT_EXISTS", "订单不存在" ); // 上游系统需要处理该错误码
        }

        AlipayTradeQueryGateInput tradeQueryRequest = new AlipayTradeQueryGateInput();
        tradeQueryRequest.setOutTradeNo( alipayAppEntity.getOutTradeNo() );
        Response<AlipayAppPayTradeOutput> queryResponse = tradeSync( alipayAppEntity, tradeQueryRequest );
        if ( queryResponse != null ) {
            return queryResponse;
        }

        AlipayAppPayTradeOutput alipayAppPayTradeResult = buildAlipayAppPayTradeResult( alipayAppEntity.getRequestNo(), alipayAppEntity );
        return ResponseUtils.success( alipayAppPayTradeResult );
    }

    private static AlipayAppPayTradeOutput buildAlipayAppPayTradeResult( String alipayAppEntity, AlipayAppEntity alipayAppEntity1 ) {
        AlipayAppPayTradeOutput alipayAppPayTradeResult = new AlipayAppPayTradeOutput();
        alipayAppPayTradeResult.setRequestNo( alipayAppEntity );
        alipayAppPayTradeResult.setStatus( alipayAppEntity1.getStatus() );
        alipayAppPayTradeResult.setTradeNo( alipayAppEntity1.getTradeNo() );
        return alipayAppPayTradeResult;
    }

    private Response<AlipayAppPayTradeOutput> tradeSync( AlipayAppEntity alipayAppEntity, AlipayTradeQueryGateInput tradeQueryRequest ) {
        Response<AlipayTradeQueryGateOutput> queryResponse = alipayGatewayService.tradeQuery( tradeQueryRequest );
        if ( !queryResponse.isSuccess() ) {
            logger.info( "支付宝网关异常: {}", queryResponse );
            return ResponseUtils.fail( "GATEWAY_ERROR", "网关异常" );
        }

        AlipayTradeQueryGateOutput responseData = queryResponse.getData();
        alipayAppEntity.setStatus( transStatus( responseData.getTradeStatus() ) );
        alipayAppEntity.setTradeNo( responseData.getTradeNo() );
        alipayAppEntity.setBuyerLogonId( responseData.getBuyerLogonId() );
        alipayAppEntity.setTradeStatus( responseData.getTradeStatus() );
        alipayAppEntity.setBuyerUserId( responseData.getBuyerUserId() );
        alipayAppEntityMapper.updateByPrimaryKeySelective( alipayAppEntity );
        return ResponseUtils.success();
    }

    public static String transStatus( String tradeStatus ) {
        String status = statusMap.get( tradeStatus );
        if ( status != null ) {
            return status;
        }
        return "PAYING";
    }
}
