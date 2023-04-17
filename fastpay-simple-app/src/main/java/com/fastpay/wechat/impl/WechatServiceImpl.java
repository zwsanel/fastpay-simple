package com.fastpay.wechat.impl;

import com.alibaba.fastjson.JSON;
import com.fastpay.common.Constants;
import com.fastpay.common.Response;
import com.fastpay.common.ResponseUtils;
import com.fastpay.wechat.WechatService;
import com.fastpay.wechat.domain.*;
import com.fastpay.wechat.entity.WechatEntity;
import com.fastpay.wechat.entity.WechatRefundEntity;
import com.fastpay.wechat.gate.WechatGateService;
import com.fastpay.wechat.gate.domain.*;
import com.fastpay.wechat.mapper.WechatEntityMapper;
import com.fastpay.wechat.mapper.WechatRefundEntityMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class WechatServiceImpl implements WechatService {

    private static final Logger logger = LogManager.getLogger( WechatServiceImpl.class );

    @Resource
    private WechatEntityMapper wechatEntityMapper;

    @Resource
    private WechatRefundEntityMapper wechatRefundEntityMapper;

    @Resource
    private WechatGateService wechatGatewayService;

    @Override
    public Response<WechatUnifiedOrderOutput> unifiedOrder( WechatUnifiedOrderInput wechatUnifiedOrderInput ) {

        WechatEntity wechatEntity = new WechatEntity();
        wechatEntity.setRequestNo( wechatUnifiedOrderInput.getRequestNo() );
        wechatEntity.setProcessNo( UUID.randomUUID().toString().replace( "-", "" ) );
        wechatEntity.setOrderNo( UUID.randomUUID().toString().replace( "-", "" ) );
        wechatEntity.setAmount( wechatUnifiedOrderInput.getAmount() );
        wechatEntity.setRemark( wechatUnifiedOrderInput.getRemark() );
        wechatEntity.setStatus( Constants.WECHAT_PAYING );
        wechatEntity.setRequestIp( wechatUnifiedOrderInput.getRequestIp() );
        wechatEntity.setTradeLimit( wechatUnifiedOrderInput.getTradeLimit() );
        wechatEntity.setTradeDesc( wechatUnifiedOrderInput.getTradeDesc() );
        wechatEntity.setTradeType( wechatUnifiedOrderInput.getTradeType() );
        wechatEntity.setExtText1( wechatUnifiedOrderInput.getExtText1() );
        wechatEntity.setOpenId( StringUtils.defaultIfEmpty( wechatUnifiedOrderInput.getOpenId(), "" ) );
        wechatEntity.setProductId( StringUtils.defaultIfEmpty( wechatUnifiedOrderInput.getProductId(), "" ) );
        wechatEntityMapper.insertSelective( wechatEntity );

        WechatPayUnifiedOrderGateInput unifiedOrderGatewayRequest = new WechatPayUnifiedOrderGateInput();
        unifiedOrderGatewayRequest.setTradeType( wechatEntity.getTradeType() );
        unifiedOrderGatewayRequest.setOpenId( wechatEntity.getOpenId() );
        unifiedOrderGatewayRequest.setAmount( wechatEntity.getAmount().movePointRight( 2 ).toString() );
        unifiedOrderGatewayRequest.setOrderNo( wechatEntity.getOrderNo() );
        unifiedOrderGatewayRequest.setRequestIp( wechatEntity.getRequestIp() );
        unifiedOrderGatewayRequest.setBody( wechatUnifiedOrderInput.getTradeDesc() );
        unifiedOrderGatewayRequest.setTradeLimit( StringUtils.isEmpty( wechatUnifiedOrderInput.getTradeLimit() ) ? "" : wechatUnifiedOrderInput.getTradeLimit() );

        unifiedOrderGatewayRequest.setBeginTime( DateFormatUtils.format( wechatEntity.getSubmitTime(), Constants.WECHAT_DATE_PATTERN ) );
        unifiedOrderGatewayRequest.setEndTime( DateFormatUtils.format( wechatEntity.getExpireTime(), Constants.WECHAT_DATE_PATTERN ) );
        unifiedOrderGatewayRequest.setSceneInfo( JSON.toJSONString( wechatUnifiedOrderInput.getSceneInfo() ) );
        unifiedOrderGatewayRequest.setProductId( wechatUnifiedOrderInput.getProductId() );
        Response<WechatPayUnifiedOrderGateOutput> gatewayResponse = wechatGatewayService.unifiedOrder( unifiedOrderGatewayRequest );

        if ( !gatewayResponse.isSuccess() ) {
            logger.info( "网关异常: {}", gatewayResponse );
            wechatEntity.setStatus( Constants.WECHAT_FAIL );
            wechatEntityMapper.updateByPrimaryKeySelective( wechatEntity );
            return ResponseUtils.fail( "ERROR", "网关异常" );
        }

        WechatPayUnifiedOrderGateOutput unifiedOrderResponse = gatewayResponse.getData();
        wechatEntity.setPrepayId( unifiedOrderResponse.getPrepayId() );
        wechatEntity.setReturnCode( unifiedOrderResponse.getReturnCode() );
        wechatEntity.setReturnMsg( unifiedOrderResponse.getReturnMsg() );
        wechatEntity.setResultCode( unifiedOrderResponse.getResultCode() );
        wechatEntity.setErrCode( unifiedOrderResponse.getErrCode() );
        wechatEntity.setErrCodeDes( unifiedOrderResponse.getErrCodeDes() );
        wechatEntity.setReturnTime( Date.from( Instant.now() ) );
        wechatEntity.setCodeUrl( StringUtils.defaultIfEmpty( unifiedOrderResponse.getCodeUrl(), "" ) );
        wechatEntity.setMwebUrl( StringUtils.defaultIfEmpty( unifiedOrderResponse.getMwebUrl(), "" ) );
        if ( Objects.equals( unifiedOrderResponse.getReturnCode(), Constants.WECHAT_FAIL ) || Objects.equals( unifiedOrderResponse.getResultCode(), Constants.WECHAT_FAIL ) ) {
            wechatEntity.setStatus( Constants.WECHAT_FAIL );
        }
        wechatEntityMapper.updateByPrimaryKeySelective( wechatEntity );

        if ( Objects.equals( wechatEntity.getStatus(), Constants.WECHAT_FAIL ) ) {
            logger.info( "微信支付下单返回失败: {}", unifiedOrderResponse );
            return ResponseUtils.fail( "ERROR", unifiedOrderResponse.getErrCodeDes() );
        }

        WechatUnifiedOrderOutput wechatUnifiedOrderOutput = new WechatUnifiedOrderOutput();
        wechatUnifiedOrderOutput.setRequestNo( wechatEntity.getRequestNo() );
        wechatUnifiedOrderOutput.setStatus( wechatEntity.getStatus() );
        wechatUnifiedOrderOutput.setOrderNo( wechatEntity.getOrderNo() );
        if ( Objects.equals( wechatEntity.getStatus(), Constants.WECHAT_PAYING ) ) { //  支付中
            WechatPayRequest wechatPayRequest = new WechatPayRequest();
            wechatPayRequest.setAppId( wechatEntity.getAppId() );
            wechatPayRequest.setPartnerId( wechatEntity.getWechatMemberNo() );
            wechatPayRequest.setPrepayId( wechatEntity.getPrepayId() );
            WechatAppPayOutput appPayRequest = unifiedOrderResponse.getAppPayRequest();
            if ( Objects.nonNull( appPayRequest ) ) {
                wechatPayRequest.setPackageStr( appPayRequest.getWxPackage() );
                wechatPayRequest.setSign( appPayRequest.getSign() );
                wechatPayRequest.setTimestamp( appPayRequest.getTimeStamp() );
                wechatPayRequest.setNonceStr( appPayRequest.getNonceStr() );
                wechatPayRequest.setSignType( appPayRequest.getSignType() );
            }
            if ( StringUtils.isNotEmpty( wechatEntity.getMwebUrl() ) ) {
                wechatPayRequest.setMwebUrl( wechatEntity.getMwebUrl() );
            }
            if ( StringUtils.isNotEmpty( wechatEntity.getCodeUrl() ) ) {
                wechatPayRequest.setCodeUrl( wechatEntity.getCodeUrl() );
            }
            wechatUnifiedOrderOutput.setWechatPayRequest( wechatPayRequest );
        }
        return ResponseUtils.success( wechatUnifiedOrderOutput );
    }

    @Override
    public Response<WechatOrderQueryOutput> orderQuery( WechatOrderQueryInput wechatOrderQueryInput ) {

        WechatEntity wechatEntity = wechatEntityMapper.selectByRequestNo( wechatOrderQueryInput.getRequestNo() );
        if ( Objects.isNull( wechatEntity ) ) {
            logger.error( "微信订单不存在" );
            return ResponseUtils.fail( "error", "订单不存在" );
        }

        WechatOrderQueryOutput wechatOrderQueryOutput = new WechatOrderQueryOutput();
        wechatOrderQueryOutput.setRequestNo( wechatEntity.getRequestNo() );
        wechatOrderQueryOutput.setAppId( wechatEntity.getAppId() );
        wechatOrderQueryOutput.setStatus( wechatEntity.getStatus() );
        wechatOrderQueryOutput.setOrderNo( wechatEntity.getOrderNo() );
        wechatOrderQueryOutput.setChannelOrderNo( wechatEntity.getOrderNo() );
        wechatOrderQueryOutput.setReturnTime( wechatEntity.getReturnTime() );
        wechatOrderQueryOutput.setPayTime( wechatEntity.getPayTime() );
        wechatOrderQueryOutput.setErrCode( wechatEntity.getErrCode() );
        wechatOrderQueryOutput.setErrCodeDesc( wechatEntity.getTradeDesc() );
        return ResponseUtils.success( wechatOrderQueryOutput );
    }

    @Override
    public Response<WechatOrderCloseOutput> orderClose( WechatOrderCloseInput wechatOrderCloseInput ) {

        WechatEntity requestEntity = wechatEntityMapper.selectByRequestNo( wechatOrderCloseInput.getRequestNo() );
        if ( Objects.equals( requestEntity.getStatus(), Constants.WECHAT_FAIL ) ) {
            logger.info( "微信订单最终状态, 跳过处理, 流水号: {}", wechatOrderCloseInput.getRequestNo() );
            return ResponseUtils.success();
        }

        if ( Objects.equals( requestEntity.getStatus(), Constants.WECHAT_SUCCESS ) ) {
            logger.info( "微信订单已处于最终状态, 本次关闭订单请求跳过处理, 流水号: {}", wechatOrderCloseInput.getRequestNo() );
            return ResponseUtils.fail( "error", "订单已支付" );
        }

        WechatCloseOrderGateInput closeOrderRequest = new WechatCloseOrderGateInput();
        closeOrderRequest.setOrderNo( requestEntity.getOrderNo() );
        Response<WechatCloseOrderGateOutput> closeOrderResponse = wechatGatewayService.closeOrder( closeOrderRequest );
        if ( !closeOrderResponse.isSuccess() ) {
            logger.error( "调用GWS关闭微信订单接口返回失败, 请求信息: {}, 返回信息: {}", closeOrderRequest, closeOrderResponse );
            return ResponseUtils.fail( "error", "网关异常" );
        }

        WechatCloseOrderGateOutput closeOrderData = closeOrderResponse.getData();
        if ( Objects.equals( closeOrderData.getReturnCode(), Constants.WECHAT_FAIL ) || Objects.equals( closeOrderData.getResultCode(), Constants.WECHAT_FAIL ) ) {
            logger.error( "关闭微信订单失败, 微信返回信息: {}", closeOrderData );
            return ResponseUtils.fail( "error", "订单关闭失败" );
        }
        return ResponseUtils.success();
    }

    @Override
    public Response<WechatRefundOutput> refund( WechatRefundInput wechatRefundInput ) {

        WechatEntity wechatEntity = wechatEntityMapper.selectByRequestNo( wechatRefundInput.getTargetRequestNo() );
        if ( wechatEntity == null ) {
            return ResponseUtils.fail( "error", "原始订单不存在" );
        }

        if ( Objects.equals( wechatEntity.getStatus(), Constants.WECHAT_PAYING ) ) {
            return ResponseUtils.fail( "error", "订单支付中，请稍后再试" );
        }

        if ( Objects.equals( wechatEntity.getStatus(), Constants.WECHAT_FAIL ) ) {
            return ResponseUtils.fail( "error", "订单失败，请核对交易" );
        }

        if ( Objects.equals( wechatEntity.getStatus(), Constants.WECHAT_SUCCESS ) ) {

            WechatRefundEntity refundEntity = new WechatRefundEntity();
            refundEntity.setRequestNo( wechatRefundInput.getRequestNo() );
            refundEntity.setProcessNo( UUID.randomUUID().toString().replace( "-", "" ) );
            refundEntity.setTargetRequestNo( wechatRefundInput.getTargetRequestNo() );
//            refundEntity.setWechatMemberNo();
            refundEntity.setOutRefundNo( UUID.randomUUID().toString().replace( "-", "" ) );
            refundEntity.setRefundFee( wechatRefundInput.getAmount() );
            refundEntity.setRefundDesc( wechatRefundInput.getRefundDesc() );
            refundEntity.setStatus( Constants.WECHAT_REFUND_REFUNDING );
            wechatRefundEntityMapper.insertSelective( refundEntity );

            WechatPayRefundGateInput refundGateInput = new WechatPayRefundGateInput();
            refundGateInput.setTransactionId( wechatEntity.getTransactionId() );
            refundGateInput.setOutTradeNo( wechatEntity.getOrderNo() );
            refundGateInput.setOutRefundNo( refundEntity.getOutRefundNo() );
            refundGateInput.setTotalFee( Integer.valueOf( wechatEntity.getAmount().movePointRight( 2 ).toString() ) );
            refundGateInput.setRefundFee( Integer.valueOf( refundEntity.getRefundFee().movePointRight( 2 ).toString() ) );
            refundGateInput.setRefundDesc( refundEntity.getRefundDesc() );
            Response<WechatPayRefundGateOutput> refundResponse = wechatGatewayService.refund( refundGateInput );
            if ( !refundResponse.isSuccess() ) {
                logger.error( "调用退款网关失败: {}", refundResponse );
                return ResponseUtils.fail( "error", "调用退款网关失败，请发起查询" );
            }

            WechatPayRefundGateOutput responseData = refundResponse.getData();
            refundEntity.setReturnCode( responseData.getReturnCode() );
            refundEntity.setReturnMsg( responseData.getReturnMsg() );
            refundEntity.setResultCode( responseData.getResultCode() );
            refundEntity.setErrCode( responseData.getErrCode() );
            refundEntity.setErrCodeDes( responseData.getErrCodeDes() );
            refundEntity.setRefundId( responseData.getRefundId() );
            //  result_code FAIL 提交业务失败
            if ( Objects.equals( responseData.getResultCode(), "FAIL" ) ) {
                refundEntity.setStatus( Constants.WECHAT_REFUND_FAIL );
            }
            wechatRefundEntityMapper.updateByPrimaryKeySelective( refundEntity );
            return ResponseUtils.success();
        }

        return ResponseUtils.fail( "error", "订单状态未知，请稍后再试" );
    }

    @Override
    public Response<WechatRefundOutput> refundQuery( WechatRefundQueryInput wechatRefundQueryInput ) {
        WechatRefundEntity refundEntity = wechatRefundEntityMapper.selectByRequestNo( wechatRefundQueryInput.getRequestNo() );
        if ( refundEntity == null ) {
            return ResponseUtils.fail( "error", "原始订单不存在" );
        }

        WechatRefundOutput response = new WechatRefundOutput();
        response.setRequestNo( refundEntity.getRequestNo() );
        response.setStatus( refundEntity.getStatus() );
        response.setSuccessTime( refundEntity.getDateUpdated() );
        response.setRecvAccout( refundEntity.getRefundRecvAccout() );
        response.setWechatRefundNo( refundEntity.getRefundId() );
        response.setErrCode( StringUtils.defaultIfEmpty( refundEntity.getErrCode(), "" ) );
        response.setErrCodeDesc( StringUtils.defaultIfEmpty( refundEntity.getErrCodeDes(), "" ) );
        return ResponseUtils.success( response );
    }
}
