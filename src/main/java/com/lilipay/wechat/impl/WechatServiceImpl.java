package com.lilipay.wechat.impl;

import com.alibaba.fastjson.JSON;
import com.lilipay.common.Constants;
import com.lilipay.common.Response;
import com.lilipay.common.ResponseUtils;
import com.lilipay.wechat.WechatService;
import com.lilipay.wechat.domain.*;
import com.lilipay.wechat.entity.WechatEntity;
import com.lilipay.wechat.gateway.WechatGateService;
import com.lilipay.wechat.gateway.domain.WechatAppPayOutput;
import com.lilipay.wechat.gateway.domain.WechatPayUnifiedOrderGateInput;
import com.lilipay.wechat.gateway.domain.WechatPayUnifiedOrderGateOutput;
import com.lilipay.wechat.mapper.WechatEntityMapper;
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

        WechatUnifiedOrderOutput weixinUnifiedOrderResponse = new WechatUnifiedOrderOutput();
        weixinUnifiedOrderResponse.setRequestNo( wechatEntity.getRequestNo() );
        weixinUnifiedOrderResponse.setStatus( wechatEntity.getStatus() );
        weixinUnifiedOrderResponse.setOrderNo( wechatEntity.getOrderNo() );
        if ( Objects.equals( wechatEntity.getStatus(), Constants.WECHAT_PAYING ) ) { //  支付中
            WeixinPayRequest weixinPayRequest = new WeixinPayRequest();
            weixinPayRequest.setAppId( wechatEntity.getAppId() );
            weixinPayRequest.setPartnerId( wechatEntity.getWechatMemberNo() );
            weixinPayRequest.setPrepayId( wechatEntity.getPrepayId() );
            WechatAppPayOutput appPayRequest = unifiedOrderResponse.getAppPayRequest();
            if ( Objects.nonNull( appPayRequest ) ) {
                weixinPayRequest.setPackageStr( appPayRequest.getWxPackage() );
                weixinPayRequest.setSign( appPayRequest.getSign() );
                weixinPayRequest.setTimestamp( appPayRequest.getTimeStamp() );
                weixinPayRequest.setNonceStr( appPayRequest.getNonceStr() );
                weixinPayRequest.setSignType( appPayRequest.getSignType() );
            }
            if ( StringUtils.isNotEmpty( wechatEntity.getMwebUrl() ) ) {
                weixinPayRequest.setMwebUrl( wechatEntity.getMwebUrl() );
            }
            if ( StringUtils.isNotEmpty( wechatEntity.getCodeUrl() ) ) {
                weixinPayRequest.setCodeUrl( wechatEntity.getCodeUrl() );
            }
            weixinUnifiedOrderResponse.setWeixinPayRequest( weixinPayRequest );
        }
        return ResponseUtils.success( weixinUnifiedOrderResponse );
    }

    @Override
    public Response<WechatOrderQueryOutput> orderQuery( WechatOrderQueryInput wechatOrderQueryInput ) {
        return null;
    }

    @Override
    public Response<WechatOrderCloseOutput> orderClose( WechatOrderCloseInput wechatOrderCloseInput ) {
        return null;
    }

    @Override
    public Response<WechatPrepayQueryOutput> prepayQuery( WechatPrepayQueryInput wechatPrepayQueryInput ) {
        return null;
    }

    @Override
    public Response<WechatRefundOutput> refund( WechatRefundInput wechatRefundInput ) {
        return null;
    }

    @Override
    public Response<WechatRefundOutput> refundQuery( WechatRefundQueryInput wechatRefundQueryInput ) {
        return null;
    }

    @Override
    public Response<WechatTransferOutput> transfer( WechatTransferInput wechatTransferInput ) {
        return null;
    }

    @Override
    public Response<WechatTransferOutput> transferQuery( WechatTransferQueryInput wechatTransferQueryInput ) {
        return null;
    }

    @Override
    public Response<WechatTradeQueryOutput> weixinTradeQuery( WechatTradeQueryInput wechatTradeQueryInput ) {
        return null;
    }
}
