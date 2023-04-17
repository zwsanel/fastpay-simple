package com.fastpay.wechat.gate.impl;

import com.fastpay.common.Response;
import com.fastpay.common.ResponseUtils;
import com.fastpay.common.utils.XMLUtils;
import com.fastpay.wechat.gate.WechatGateService;
import com.fastpay.wechat.gate.domain.*;
import com.fastpay.wechat.gate.message.*;
import com.fastpay.wechat.utils.HttpUtils;
import com.fastpay.wechat.utils.SignUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.StringEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WechatGateServiceImpl implements WechatGateService {

    private static final Logger logger = LogManager.getLogger( WechatGateServiceImpl.class );

    @Value( "${wechat.appid:}" )
    private String appId;

    @Value( "${wechat.memberNo:}" )
    private String memberNo;

    @Value( "${wechat.key:}" )
    private String key;

    @Value( "${wechat.notifyUrl:}" )
    private String notifyUrl;

    @Value( "${wechat.refundNotifyUrl:}" )
    private String refundNotifyUrl;

    @Value( "${wechat.wxHost:}" )
    private String wxHost;

    private static final String CHARSET = "UTF-8";

    @Override
    public Response<WechatPayUnifiedOrderGateOutput> unifiedOrder( WechatPayUnifiedOrderGateInput wechatPayUnifiedOrderGateInput ) {

        WechatPayUnifiedOrderInputXml inputXml = new WechatPayUnifiedOrderInputXml();
        inputXml.setAppId( appId );
        inputXml.setMemberNo( memberNo );
        inputXml.setNonceStr( SignUtils.getRandomLess32() );
        inputXml.setBody( wechatPayUnifiedOrderGateInput.getBody() );
        inputXml.setOrderNo( wechatPayUnifiedOrderGateInput.getOrderNo() );
        inputXml.setAmount( wechatPayUnifiedOrderGateInput.getAmount() );
        inputXml.setCreateIp( wechatPayUnifiedOrderGateInput.getRequestIp() );
        inputXml.setBeginTime( wechatPayUnifiedOrderGateInput.getBeginTime() );
        inputXml.setEndTime( wechatPayUnifiedOrderGateInput.getEndTime() );
        inputXml.setNotifyUrl( notifyUrl );
        inputXml.setTradeType( wechatPayUnifiedOrderGateInput.getTradeType() );
        String tradeLimit = wechatPayUnifiedOrderGateInput.getTradeLimit();
        //如果交易类型为空或者交易类型为还款，那么就不支持行用卡
        if ( StringUtils.isEmpty( tradeLimit ) || "no_credit".equals( tradeLimit ) ) {
            inputXml.setLimitPay( "no_credit" );
        }

        if ( StringUtils.equals( "JSAPI", wechatPayUnifiedOrderGateInput.getTradeType() ) ) {
            if ( StringUtils.isEmpty( wechatPayUnifiedOrderGateInput.getOpenId() ) ) {
                return ResponseUtils.fail( "", "微信小程序统一下单参数校验失败,openId不能为空！" );
            }
            inputXml.setOpenid( wechatPayUnifiedOrderGateInput.getOpenId() );
        }

        if ( StringUtils.equals( "MWEB", wechatPayUnifiedOrderGateInput.getTradeType() ) ) {
            if ( StringUtils.isEmpty( wechatPayUnifiedOrderGateInput.getSceneInfo() ) ) {
                return ResponseUtils.fail( "", "微信h5统一下单参数校验失败,sceneInfo不能为空！" );
            }
            inputXml.setSceneInfo( wechatPayUnifiedOrderGateInput.getSceneInfo() );
        }

        if ( StringUtils.equals( "NATIVE", wechatPayUnifiedOrderGateInput.getTradeType() ) ) {
            inputXml.setProductId( wechatPayUnifiedOrderGateInput.getProductId() );
        }

        String reqXml = XMLUtils.toString( inputXml );
        inputXml.setSign( SignUtils.sign( reqXml, key, CHARSET ) );
        String requestXml = XMLUtils.toString( inputXml );

        logger.info( "微信统一下单接口请求: {}", requestXml );
        HttpUtils.Result<String> postResult = HttpUtils.sendPostRequest( wxHost + "/pay/unifiedorder", new StringEntity( requestXml, CHARSET ) );
        if ( !postResult.isSuccess() ) {
            logger.error( "微信统一下单接口请求失败: {}", postResult.getData() );
            return ResponseUtils.fail( "error", "网关请求失败" );
        }

        String result = postResult.getData();
        logger.info( "微信统一下单接口返回: {}", result );

        WechatPayUnifiedOrderOutputXml outputXml = XMLUtils.toObject( result, WechatPayUnifiedOrderOutputXml.class );
        WechatPayUnifiedOrderGateOutput unifiedOrderResponse = new WechatPayUnifiedOrderGateOutput();
        unifiedOrderResponse.setReturnCode( outputXml.getReturnCode() );
        unifiedOrderResponse.setReturnMsg( outputXml.getReturnMsg() );
        if ( Objects.equals( "FAIL", outputXml.getReturnCode() ) ) {
            return ResponseUtils.success( unifiedOrderResponse );
        }
        if ( !SignUtils.verifySign( result, key, CHARSET ) ) {
            logger.error( "微信统一下单接口签名验证失败, request: {}, appKey: {}", result, key );
            return ResponseUtils.fail( "", "签名验证失败" );
        }
        unifiedOrderResponse.setResultCode( outputXml.getResultCode() );
        unifiedOrderResponse.setErrCode( outputXml.getErrCode() );
        unifiedOrderResponse.setErrCodeDes( outputXml.getErrCodeDes() );

        //成功返回预付单参数后封装app端请求参数
        if ( Objects.equals( "SUCCESS", outputXml.getResultCode() ) ) {
            if ( Objects.equals( outputXml.getTradeType(), "APP" ) ) {
                WechatAppPayOutput appPayRequest = new WechatAppPayOutput();
                appPayRequest.setAppId( appId );
                appPayRequest.setPartnerId( memberNo );
                appPayRequest.setNonceStr( SignUtils.getRandomLess32() );
                appPayRequest.setTimeStamp( String.valueOf( System.currentTimeMillis() / 1000 ) );
                appPayRequest.setWxPackage( "Sign=WXPay" );
                appPayRequest.setPrepayId( outputXml.getPrepayId() );
                String appPayRequestXml = XMLUtils.toString( appPayRequest );
                appPayRequest.setSign( SignUtils.sign( appPayRequestXml, key, CHARSET ) );
                unifiedOrderResponse.setPrepayId( outputXml.getPrepayId() );
                unifiedOrderResponse.setAppPayRequest( appPayRequest );
            }

            if ( Objects.equals( outputXml.getTradeType(), "JSAPI" ) ) {
                WechatJsapiResignDomain weixinJsapiResignDomain = new WechatJsapiResignDomain();
                weixinJsapiResignDomain.setAppid( outputXml.getAppId() );
                weixinJsapiResignDomain.setNonceStr( SignUtils.getRandomLess32() );
                weixinJsapiResignDomain.setTimeStamp( String.valueOf( System.currentTimeMillis() / 1000 ) );
                weixinJsapiResignDomain.setWxPackage( "prepay_id=" + outputXml.getPrepayId() );
                weixinJsapiResignDomain.setSignType( "MD5" );

                WechatAppPayOutput appPayRequest = new WechatAppPayOutput();
                appPayRequest.setTimeStamp( weixinJsapiResignDomain.getTimeStamp() );
                appPayRequest.setNonceStr( weixinJsapiResignDomain.getNonceStr() );
                appPayRequest.setWxPackage( weixinJsapiResignDomain.getWxPackage() );
                appPayRequest.setSignType( weixinJsapiResignDomain.getSignType() );
                appPayRequest.setSign( SignUtils.signJsapi( XMLUtils.toString( weixinJsapiResignDomain ), key ) );
                unifiedOrderResponse.setPrepayId( outputXml.getPrepayId() );
                unifiedOrderResponse.setAppPayRequest( appPayRequest );
            }

            if ( Objects.equals( outputXml.getTradeType(), "MWEB" ) ) {
                unifiedOrderResponse.setPrepayId( outputXml.getPrepayId() );
                unifiedOrderResponse.setMwebUrl( outputXml.getMwebUrl() );
            }

            if ( Objects.equals( outputXml.getTradeType(), "NATIVE" ) ) {
                unifiedOrderResponse.setPrepayId( outputXml.getPrepayId() );
                unifiedOrderResponse.setCodeUrl( outputXml.getCodeUrl() );
            }
        }
        return ResponseUtils.success( unifiedOrderResponse );
    }

    @Override
    public Response<WechatPayOrderQueryGateOutput> orderQuery( WechatPayOrderQueryGateInput wechatPayOrderQueryGateInput ) {

        WechatPayOrderQueryInputXml inputXml = new WechatPayOrderQueryInputXml();
        inputXml.setAppid( appId );
        inputXml.setMchId( memberNo );
        inputXml.setTransactionId( wechatPayOrderQueryGateInput.getTransactionId() );
        inputXml.setOutTradeNo( wechatPayOrderQueryGateInput.getOutTradeNo() );
        inputXml.setNonceStr( SignUtils.getRandomLess32() );

        String reqXml = XMLUtils.toString( inputXml );
        inputXml.setSign( SignUtils.sign( reqXml, key, CHARSET ) );
        reqXml = XMLUtils.toString( inputXml );

        logger.info( "微信订单查询接口请求参数：{}", reqXml );
        HttpUtils.Result<String> postResult = HttpUtils.sendPostRequest( wxHost + "/pay/orderquery", new StringEntity( reqXml, CHARSET ) );
        if ( !postResult.isSuccess() ) {
            logger.error( "微信订单查询接口请求失败: {}", postResult.getData() );
            return ResponseUtils.fail( "error", "网关请求失败" );
        }
        String result = postResult.getData();
        logger.info( "微信订单查询接口响应参数：{}", result );

        if ( StringUtils.isEmpty( result ) ) {
            logger.error( "微信订单查询接口返回为空,请求参数：{}", reqXml );
            return ResponseUtils.fail( "", "微信订单查询接口返回为空！" );
        }

        WechatPayOrderQueryOutputXml outputXml = XMLUtils.toObject( result, WechatPayOrderQueryOutputXml.class );
        WechatPayOrderQueryGateOutput response = new WechatPayOrderQueryGateOutput();
        response.setReturnCode( outputXml.getReturnCode() );
        response.setReturnMsg( outputXml.getReturnMsg() );
        if ( Objects.equals( "FAIL", outputXml.getReturnCode() ) ) {
            return ResponseUtils.success( response );
        }

        boolean verify = SignUtils.verifySign( result, key, CHARSET );
        if ( !verify ) {
            logger.error( "微信订单查询验签失败！返回参数：{}", outputXml );
            return ResponseUtils.fail( "", "微信订单查询接口验签失败！" );
        }
        response.setResultCode( outputXml.getResultCode() );
        response.setErrCode( outputXml.getErrCode() );
        response.setErrCodeDes( outputXml.getErrCodeDes() );
        response.setOutTradeNo( outputXml.getOutTradeNo() );
        response.setTransactionId( outputXml.getTransactionId() );
        response.setTradeState( outputXml.getTradeState() );
        response.setTradeStateDesc( outputXml.getTradeStateDesc() );
        response.setBankType( outputXml.getBankType() );
        response.setOpenId( outputXml.getOpenid() );
        response.setTimeEnd( outputXml.getTimeEnd() );
        return ResponseUtils.success( response );
    }

    @Override
    public Response<WechatPayNoticeGateOutput> acceptNotice( WechatPayNoticeGateInput wechatPayNoticeGateInput ) {
        String noticeXml = wechatPayNoticeGateInput.getNoticeXml();
        boolean verify = SignUtils.verifySign( noticeXml, key, CHARSET );
        if ( !verify ) {
            logger.error( "微信订单查询验签失败！返回参数：{}", noticeXml );
            return ResponseUtils.fail( "", "微信订单查询接口验签失败！" );
        }
        WechatPayOrderNoticeXml weixinPayOrderNoticeXml = XMLUtils.toObject( noticeXml, WechatPayOrderNoticeXml.class );
        WechatPayNoticeGateOutput response = new WechatPayNoticeGateOutput();
        response.setReturnCode( weixinPayOrderNoticeXml.getReturnCode() );
        response.setReturnMsg( weixinPayOrderNoticeXml.getReturnMsg() );
        response.setResultCode( weixinPayOrderNoticeXml.getResultCode() );
        response.setErrCode( weixinPayOrderNoticeXml.getErrCode() );
        response.setErrCodeDes( weixinPayOrderNoticeXml.getErrCodeDes() );
        response.setTransactionId( weixinPayOrderNoticeXml.getTransactionId() );
        response.setOutTradeNo( weixinPayOrderNoticeXml.getOutTradeNo() );
        response.setTimeEnd( weixinPayOrderNoticeXml.getTimeEnd() );
        response.setBankType( weixinPayOrderNoticeXml.getBankType() );
        response.setOpenId( weixinPayOrderNoticeXml.getOpenid() );
        return ResponseUtils.success( response );
    }

    @Override
    public Response<WechatCloseOrderGateOutput> closeOrder( WechatCloseOrderGateInput wechatCloseOrderGateInput ) {

        WechatCloseOrderInputXml closeOrderInputXml = new WechatCloseOrderInputXml();
        closeOrderInputXml.setAppid( appId );
        closeOrderInputXml.setMchId( memberNo );
        closeOrderInputXml.setOutTradeNo( wechatCloseOrderGateInput.getOrderNo() );
        closeOrderInputXml.setNonceStr( SignUtils.getRandomLess32() );
        closeOrderInputXml.setSign( SignUtils.sign( XMLUtils.toString( closeOrderInputXml ), key, CHARSET ) );
        String requestStr = XMLUtils.toString( closeOrderInputXml );
        logger.info( "开始调用微信关闭订单接口: {}", requestStr );
        HttpUtils.Result<String> postResult = HttpUtils.sendPostRequest( wxHost + "/pay/closeorder", new StringEntity( requestStr, CHARSET ) );
        if ( !postResult.isSuccess() ) {
            logger.error( "微信关闭订单失败: {}", postResult.getData() );
            return ResponseUtils.fail( "error", "网关请求失败" );
        }
        String responseStr = postResult.getData();
        logger.info( "调用微信关闭订单接口返回: {}", responseStr );
        WechatCloseOrderOutputXml closeOrderOutputXml = XMLUtils.toObject( responseStr, WechatCloseOrderOutputXml.class );
        WechatCloseOrderGateOutput closeOrderResponse = new WechatCloseOrderGateOutput();
        closeOrderResponse.setReturnCode( closeOrderOutputXml.getReturnCode() );
        closeOrderResponse.setReturnMsg( closeOrderOutputXml.getReturnMsg() );
        if ( Objects.equals( "FAIL", closeOrderResponse.getReturnCode() ) ) {
            return ResponseUtils.success( closeOrderResponse );
        }
        boolean verify = SignUtils.verifySign( responseStr, key, CHARSET );
        if ( !verify ) {
            logger.error( "关闭微信订单请求验签失败！验签参数：{}", responseStr );
            return ResponseUtils.fail( "", "微信订单查询接口验签失败！" );
        }
        closeOrderResponse.setResultCode( closeOrderOutputXml.getResultCode() );
        closeOrderResponse.setErrCode( closeOrderOutputXml.getErrCode() );
        closeOrderResponse.setErrCodeDes( closeOrderOutputXml.getErrCodeDes() );
        return ResponseUtils.success( closeOrderResponse );
    }

    @Override
    public Response<WechatPayRefundGateOutput> refund( WechatPayRefundGateInput wechatPayRefundGateInput ) {

        WechatPayRefundInputXml refundInputXml = new WechatPayRefundInputXml();
        refundInputXml.setAppid( appId );
        refundInputXml.setMch_id( memberNo );
        refundInputXml.setNonce_str( SignUtils.getRandomLess32() );
        refundInputXml.setTransaction_id( wechatPayRefundGateInput.getTransactionId() );
        refundInputXml.setOut_trade_no( wechatPayRefundGateInput.getOutTradeNo() );
        refundInputXml.setOut_refund_no( wechatPayRefundGateInput.getOutRefundNo() );
        refundInputXml.setTotal_fee( wechatPayRefundGateInput.getTotalFee() );
        refundInputXml.setRefund_fee( wechatPayRefundGateInput.getRefundFee() );
        refundInputXml.setRefund_fee_type( wechatPayRefundGateInput.getRefundFeeType() );
        refundInputXml.setRefund_desc( wechatPayRefundGateInput.getRefundDesc() );
        refundInputXml.setRefund_account( wechatPayRefundGateInput.getRefundAccount() );
        if ( StringUtils.isNotEmpty( refundNotifyUrl ) ) {
            refundInputXml.setNotify_url( refundNotifyUrl );
        }

        String requestStr = XMLUtils.toString( refundInputXml );
        refundInputXml.setSign( SignUtils.sign( requestStr, key, CHARSET ) );
        requestStr = XMLUtils.toString( refundInputXml );

        logger.info( "开始调用微信申请退款: {}", refundInputXml );
        HttpUtils.Result<String> postResult = HttpUtils.sendPostRequest( wxHost + "/secapi/pay/refund", new StringEntity( requestStr, CHARSET ) );
        if ( !postResult.isSuccess() ) {
            logger.error( "微信关闭订单失败: {}", postResult.getData() );
            return ResponseUtils.fail( "error", "网关请求失败" );
        }

        String responseStr = postResult.getData();
        logger.info( "调用微信申请退款返回: {}", responseStr );

        WechatPayRefundOutputXml refundOutputXml = XMLUtils.toObject( responseStr, WechatPayRefundOutputXml.class );

        WechatPayRefundGateOutput refundResponse = new WechatPayRefundGateOutput();
        refundResponse.setReturnCode( refundOutputXml.getReturn_code() );
        refundResponse.setReturnMsg( refundOutputXml.getReturn_msg() );
        if ( Objects.equals( refundResponse.getReturnCode(), "SUCCESS" ) ) {
            refundResponse.setResultCode( refundOutputXml.getResult_code() );
            refundResponse.setErrCode( refundOutputXml.getErr_code() );
            refundResponse.setErrCodeDes( refundOutputXml.getErr_code_des() );
            refundResponse.setRefundId( refundOutputXml.getRefund_id() );
            refundResponse.setRefundFee( refundOutputXml.getRefund_fee() );
            refundResponse.setSettlementRefundFee( refundOutputXml.getSettlement_refund_fee() );
            refundResponse.setTotalFee( refundOutputXml.getTotal_fee() );
            refundResponse.setSettlementTotalFee( refundOutputXml.getSettlement_total_fee() );
            refundResponse.setFeeType( refundOutputXml.getFee_type() );
            refundResponse.setCashFee( refundOutputXml.getCash_fee() );
            refundResponse.setCashFeeType( refundOutputXml.getCash_fee_type() );
            refundResponse.setCashRefundFee( refundOutputXml.getCash_refund_fee() );
            if ( !SignUtils.verifySign( responseStr, key, CHARSET ) ) {
                logger.error( "微信申请退款返回数据验签失败, 返回数据: {}", responseStr );
                return ResponseUtils.fail( "", "微信申请退款返回数据验签失败" );
            }
        }
        return ResponseUtils.success( refundResponse );
    }

    @Override
    public Response<WechatPayRefundQueryGateOutput> refundQuery( WechatPayRefundQueryGateInput wechatPayRefundQueryGateInput ) {

        WechatPayRefundQueryInputXml refundQueryInputXml = new WechatPayRefundQueryInputXml();
        refundQueryInputXml.setAppid( wechatPayRefundQueryGateInput.getAppId() );
        refundQueryInputXml.setMch_id( wechatPayRefundQueryGateInput.getMchId() );
        refundQueryInputXml.setNonce_str( SignUtils.getRandomLess32() );
        refundQueryInputXml.setTransaction_id( wechatPayRefundQueryGateInput.getTransactionId() );
        refundQueryInputXml.setOut_trade_no( wechatPayRefundQueryGateInput.getOutTradeNo() );
        refundQueryInputXml.setOut_refund_no( wechatPayRefundQueryGateInput.getOutRefundNo() );
        refundQueryInputXml.setRefund_id( wechatPayRefundQueryGateInput.getRefundId() );
        refundQueryInputXml.setOffset( wechatPayRefundQueryGateInput.getOffset() );

        String requestStr = XMLUtils.toString( refundQueryInputXml );
        refundQueryInputXml.setSign( SignUtils.sign( requestStr, wechatPayRefundQueryGateInput.getApiKey(), CHARSET ) );
        requestStr = XMLUtils.toString( refundQueryInputXml );

        logger.info( "开始查询微信退款结果: {}", refundQueryInputXml );
        HttpUtils.Result<String> postResult = HttpUtils.sendPostRequest( wxHost + "/pay/refundquery", new StringEntity( requestStr, CHARSET ) );
        if ( !postResult.isSuccess() ) {
            logger.error( "查询微信退款结果: {}", postResult.getData() );
            return ResponseUtils.fail( "error", "网关请求失败" );
        }
        String responseStr = postResult.getData();
        logger.info( "查询微信退款结果返回: {}", responseStr );

        WechatPayRefundQueryOutputXml refundQueryOutputXml = XMLUtils.toObject( responseStr, WechatPayRefundQueryOutputXml.class );

        WechatPayRefundQueryGateOutput refundQueryResponse = new WechatPayRefundQueryGateOutput();
        refundQueryResponse.setReturnCode( refundQueryOutputXml.getReturn_code() );
        refundQueryResponse.setReturnMsg( refundQueryOutputXml.getReturn_msg() );
        if ( Objects.equals( refundQueryResponse.getReturnCode(), "SUCCESS" ) ) {
            refundQueryResponse.setResultCode( refundQueryOutputXml.getResult_code() );
            refundQueryResponse.setErrCode( refundQueryOutputXml.getErr_code() );
            refundQueryResponse.setErrCodeDes( refundQueryOutputXml.getErr_code_des() );
            refundQueryResponse.setTransactionId( refundQueryOutputXml.getTransaction_id() );
            refundQueryResponse.setOutTradeNo( refundQueryOutputXml.getOut_trade_no() );
            refundQueryResponse.setTotalRefundCount( refundQueryOutputXml.getTotal_refund_count() );
            refundQueryResponse.setTotalFee( refundQueryOutputXml.getTotal_fee() );
            refundQueryResponse.setFeeType( refundQueryOutputXml.getFee_type() );
            refundQueryResponse.setCashFee( refundQueryOutputXml.getCash_fee() );
            refundQueryResponse.setSettlementTotalFee( refundQueryOutputXml.getSettlement_total_fee() );
            refundQueryResponse.setRefundCount( refundQueryOutputXml.getRefund_count() );
            refundQueryResponse.setOutRefundNo( refundQueryOutputXml.getOut_trade_no() );
            refundQueryResponse.setRefundId( refundQueryOutputXml.getRefund_id_0() );
            refundQueryResponse.setRefundChannel( refundQueryOutputXml.getRefund_channel_0() );
            refundQueryResponse.setRefundFee( refundQueryOutputXml.getRefund_fee_0() );
            refundQueryResponse.setRefundStatus( refundQueryOutputXml.getRefund_status_0() );
            refundQueryResponse.setRefundAccount( refundQueryOutputXml.getRefund_account_0() );
            refundQueryResponse.setRefundRecvAccout( refundQueryOutputXml.getRefund_recv_accout_0() );
            refundQueryResponse.setRefundSuccessTime( refundQueryOutputXml.getRefund_success_time_0() );
            if ( !SignUtils.verifySign( responseStr, key, CHARSET ) ) {
                logger.error( "查询微信退款结果返回数据验签失败, 返回数据: {}", responseStr );
                return ResponseUtils.fail( "", "查询微信退款结果返回数据验签失败" );
            }
        }
        return ResponseUtils.success( refundQueryResponse );
    }

    @Override
    public Response<WechatPayRefundNoticeGateOutput> acceptRefundNotice( WechatPayRefundNoticeGateInput wechatPayRefundNoticeGateInput ) {
        String noticeXml = wechatPayRefundNoticeGateInput.getNoticeXml();
        String apiKey = wechatPayRefundNoticeGateInput.getApiKey();
        boolean verifySignResult = SignUtils.verifySign( noticeXml, apiKey, CHARSET );
        if ( !verifySignResult ) {
            logger.error( "微信退款结果通知返回数据验签失败, 返回数据: {}", noticeXml );
            return ResponseUtils.fail( "", "微信退款结果通知返回数据验签失败" );
        }
        WechatPayRefundResultNoticeXml refundResultNoticeXml = XMLUtils.toObject( noticeXml, WechatPayRefundResultNoticeXml.class );
        WechatPayRefundNoticeGateOutput refundNoticeResponse = new WechatPayRefundNoticeGateOutput();
        refundNoticeResponse.setReturnCode( refundResultNoticeXml.getReturn_code() );
        refundNoticeResponse.setReturnMsg( refundResultNoticeXml.getReturn_msg() );
        if ( Objects.equals( refundResultNoticeXml.getReturn_code(), "SUCCESS" ) ) {
            String reqInfoStr = refundResultNoticeXml.getReq_info();
            String reqInfoXml = SignUtils.decodeRefundReqInfo( reqInfoStr, apiKey );
            WechatPayRefundResultReqInfoXml refundResultReqInfoXml = XMLUtils.toObject( reqInfoXml, WechatPayRefundResultReqInfoXml.class );
            refundNoticeResponse.setTransactionId( refundResultReqInfoXml.getTransaction_id() );
            refundNoticeResponse.setOutTradeNo( refundResultReqInfoXml.getOut_trade_no() );
            refundNoticeResponse.setRefundId( refundResultReqInfoXml.getRefund_id() );
            refundNoticeResponse.setOutRefundNo( refundResultReqInfoXml.getOut_refund_no() );
            refundNoticeResponse.setTotalFee( refundResultReqInfoXml.getTotal_fee() );
            refundNoticeResponse.setSettlementTotalFee( refundResultReqInfoXml.getSettlement_total_fee() );
            refundNoticeResponse.setRefundFee( refundResultReqInfoXml.getRefund_fee() );
            refundNoticeResponse.setSettlementRefundFee( refundResultReqInfoXml.getSettlement_refund_fee() );
            refundNoticeResponse.setRefundStatus( refundResultReqInfoXml.getRefund_status() );
            refundNoticeResponse.setSuccessTime( refundResultReqInfoXml.getSuccess_time() );
            refundNoticeResponse.setRefundRecvAccout( refundResultReqInfoXml.getRefund_recv_accout() );
            refundNoticeResponse.setRefundAccount( refundResultReqInfoXml.getRefund_account() );
            refundNoticeResponse.setRefundRequestSource( refundResultReqInfoXml.getRefund_request_source() );
        }
        return ResponseUtils.success( refundNoticeResponse );
    }
}
