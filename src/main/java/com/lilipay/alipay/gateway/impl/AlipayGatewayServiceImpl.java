package com.lilipay.alipay.gateway.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.lilipay.alipay.gateway.AlipayGatewayService;
import com.lilipay.alipay.gateway.domain.*;
import com.lilipay.common.Response;
import com.lilipay.common.ResponseUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlipayGatewayServiceImpl implements AlipayGatewayService {

    private static final Logger logger = LogManager.getLogger( AlipayGatewayServiceImpl.class );

    @Value( "${alipay.serverUrl}" )
    private String serverUrl;

    @Value( "${alipay.appId}" )
    private String appId;

    @Value( "${alipay.privateKey}" )
    private String privateKey;

    @Value( "${alipay.publicKey}" )
    private String publicKey;

    @Value( "${alipay.notifyUrl}" )
    private String notifyUrl;

    private volatile AlipayClient alipayClient;

    private AlipayClient alipayClient() {
        if ( alipayClient == null ) {
            synchronized ( this ) {
                if ( alipayClient == null ) {
                    alipayClient = new DefaultAlipayClient( serverUrl, appId, privateKey, "json", "UTF-8", publicKey, "RSA2" );
                }
            }
        }
        return alipayClient;
    }

    @Override
    public Response<AlipayAppPayGatewayResult> appPay( AlipayAppPayGatewayRequest appPayRequest ) {
        try {
            AlipayTradeAppPayModel tradeAppPayModel = new AlipayTradeAppPayModel();
            tradeAppPayModel.setTimeoutExpress( appPayRequest.getTimeoutExpress() );
            tradeAppPayModel.setTimeExpire( appPayRequest.getTimeExpire() );
            tradeAppPayModel.setTotalAmount( appPayRequest.getTotalAmount() );
            tradeAppPayModel.setProductCode( "QUICK_MSECURITY_PAY" );
            tradeAppPayModel.setGoodsType( appPayRequest.getGoodsType() );
            tradeAppPayModel.setSubject( appPayRequest.getSubject() );
            tradeAppPayModel.setOutTradeNo( appPayRequest.getOutTradeNo() );
            tradeAppPayModel.setBody( appPayRequest.getBody() );
            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
            request.setBizModel( tradeAppPayModel );
            request.setNotifyUrl( notifyUrl );
            AlipayTradeAppPayResponse response = alipayClient().sdkExecute( request );
            AlipayAppPayGatewayResult result = new AlipayAppPayGatewayResult();
            result.setCode( response.getCode() );
            result.setMsg( response.getMsg() );
            result.setSubCode( response.getSubCode() );
            result.setSubMsg( response.getSubMsg() );
            result.setOrderInfo( response.getBody() );
            return ResponseUtils.success( result );
        } catch ( Exception e ) {
            logger.error( "支付宝APP支付接口异常, request: {}", appPayRequest, e );
            return ResponseUtils.fail( "ERROR", "支付宝统一收单线下交易查询异常" );
        }
    }

    @Override
    public Response<AlipayTradeQueryGatewayResult> tradeQuery( AlipayTradeQueryGatewayRequest tradeQueryRequest ) {
        try {
            AlipayTradeQueryModel model = new AlipayTradeQueryModel();
            model.setOutTradeNo( tradeQueryRequest.getOutTradeNo() );
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
            request.setBizModel( model );
            AlipayTradeQueryResponse response = alipayClient().execute( request );
            AlipayTradeQueryGatewayResult result = new AlipayTradeQueryGatewayResult();
            result.setTradeNo( response.getTradeNo() );
            result.setOutTradeNo( response.getOutTradeNo() );
            result.setBuyerLogonId( response.getBuyerLogonId() );
            result.setTradeStatus( response.getTradeStatus() );
            result.setTotalAmount( response.getTotalAmount() );
            result.setBuyerUserId( response.getBuyerUserId() );
            result.setCode( response.getCode() );
            result.setMsg( response.getMsg() );
            result.setSubCode( response.getSubCode() );
            result.setSubMsg( response.getSubMsg() );
            return ResponseUtils.success( result );
        } catch ( Exception e ) {
            logger.error( "支付宝统一收单线下交易查询 接口异常, request: {}", tradeQueryRequest, e );
            return ResponseUtils.fail( "ERROR", "支付宝统一收单线下交易查询异常" );
        }
    }

    @Override
    public Response<AlipayTradeCloseGatewayResult> tradeClose( AlipayTradeCloseGatewayRequest tradeCloseRequest ) {
        try {
            AlipayTradeCloseModel model = new AlipayTradeCloseModel();
            model.setOutTradeNo( tradeCloseRequest.getOutTradeNo() );
            AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
            request.setBizModel( model );
            AlipayTradeCloseResponse response = alipayClient().execute( request );
            AlipayTradeCloseGatewayResult tradeCloseResult = new AlipayTradeCloseGatewayResult();
            tradeCloseResult.setTradeNo( response.getTradeNo() );
            tradeCloseResult.setOutTradeNo( response.getOutTradeNo() );
            tradeCloseResult.setCode( response.getCode() );
            tradeCloseResult.setMsg( response.getMsg() );
            tradeCloseResult.setSubCode( response.getSubCode() );
            tradeCloseResult.setSubMsg( response.getSubMsg() );
            return ResponseUtils.success( tradeCloseResult );
        } catch ( Exception e ) {
            logger.error( "支付宝订单关闭接口异常, request: {}", tradeCloseRequest, e );
            return ResponseUtils.fail( "ERROR", "支付宝统一收单线下交易查询异常" );
        }
    }
}
