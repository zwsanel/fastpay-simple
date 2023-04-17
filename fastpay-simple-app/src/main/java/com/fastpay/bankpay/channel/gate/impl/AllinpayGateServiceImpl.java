package com.fastpay.bankpay.channel.gate.impl;

import com.fastpay.bankpay.channel.gate.AllinpayGateService;
import com.fastpay.bankpay.channel.gate.domain.PayInGateInput;
import com.fastpay.bankpay.channel.gate.domain.PayInGateOutput;
import com.fastpay.bankpay.channel.gate.domain.PayInQueryGateInput;
import com.fastpay.bankpay.channel.gate.domain.PayInQueryGateOutput;
import com.fastpay.bankpay.channel.gate.message.m100011.*;
import com.fastpay.bankpay.channel.gate.message.m200004.*;
import com.fastpay.bankpay.channel.gate.utils.HttpUtils;
import com.fastpay.bankpay.channel.gate.utils.SignUtils;
import com.fastpay.common.Response;
import com.fastpay.common.ResponseUtils;
import com.fastpay.common.utils.XMLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.fastpay.common.Constants.ALLINPAY_DATE_PATTERN;

@Service
public class AllinpayGateServiceImpl implements AllinpayGateService {

    private static final Logger logger = LogManager.getLogger( AllinpayGateServiceImpl.class );

    /**
     * 商户号
     */
    @Value( "${allinpay.merchantId:}" )
    private String merchantId;

    /**
     * 用户名
     */
    @Value( "${allinpay.userName:}" )
    private String userName;

    /**
     * 用户密码
     */
    @Value( "${allinpay.userPass:}" )
    private String userPass;

    /**
     * 业务代码
     */
    @Value( "${allinpay.businessCode:}" )
    private String businessCode;

    /**
     * 通知地址
     */
    @Value( "${allinpay.notifyUrl:}" )
    private String notifyUrl;

    /**
     * 公钥
     */
    @Value( "${allinpay.publicKey:}" )
    private String publicKey;

    /**
     * 私钥
     */
    @Value( "${allinpay.privateKey:}" )
    private String privateKey;

    /**
     * 请求地址
     */
    @Value( "${allinpay.url:}" )
    private String url;

    @Override
    public Response<PayInGateOutput<Void>> payIn( PayInGateInput payInGateInput ) {

        ReqAipg100011 aipg100011 = new ReqAipg100011();
        ReqInfo100011 info100011 = new ReqInfo100011();
        info100011.setTrxCode( "100011" );
        info100011.setVersion( "05" );
        info100011.setDataType( "2" );
        info100011.setLevel( "5" );
        info100011.setMerchantId( merchantId );
        info100011.setUserName( userName );
        info100011.setUserPass( userPass );
        info100011.setReqSn( payInGateInput.getOrderNo() );
        aipg100011.setInfo( info100011 );
        ReqTrans100011 trans100011 = new ReqTrans100011();
        trans100011.setBusinessCode( businessCode );
        trans100011.setMerchantId( merchantId );
        trans100011.setSubmitTime( DateTimeFormatter.ofPattern( ALLINPAY_DATE_PATTERN ).format( LocalDateTime.now().atZone( ZoneOffset.systemDefault() ) ) );
        trans100011.setAccountType( "00" );
        trans100011.setBankCode( payInGateInput.getBankCode() );
        trans100011.setAccountNo( payInGateInput.getCardNo() );
        trans100011.setAccountName( payInGateInput.getCardName() );
        trans100011.setAmount( payInGateInput.getAmount().movePointRight( 2 ).toString() );
        trans100011.setCurrency( "CNY" );
        trans100011.setIdType( "0" );
        trans100011.setId( payInGateInput.getIdNo() );
        trans100011.setTel( payInGateInput.getCardMobile() );
        trans100011.setNotifyUrl( notifyUrl );
        aipg100011.setTrans( trans100011 );
        //  原始字符串加签
        String xmlStr = XMLUtils.toString( aipg100011 );
        String signStr; //SM3withSM2 加签，使用老算法版本请联系开发者
        try {
            signStr = SignUtils.signXml( xmlStr, publicKey, privateKey );
        } catch ( NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e ) {
            logger.error( "通联支付签名失败" );
            return ResponseUtils.fail( "error", "签名失败" );
        }
        //  更新签名
        info100011.setSignedMsg( signStr );
        String reqXmlStr = XMLUtils.toString( aipg100011 );
        String resXmlStr;
        try {
            resXmlStr = HttpUtils.postXml( url, reqXmlStr );
        } catch ( IOException e ) {
            return ResponseUtils.fail( "error", "网络异常" );
        }
        ResAipg100011 resAipg = XMLUtils.toObject( resXmlStr, ResAipg100011.class );
        ResInfo100011 resInfo = resAipg.getInfo();
        ResTransret100011 resTransret = resAipg.getTransret();

        PayInGateOutput<Void> payInGateOutput = new PayInGateOutput<>();
        if ( resInfo != null ) {
            payInGateOutput.setRetCode1( resInfo.getRetCode() );
            payInGateOutput.setRetMsg1( resInfo.getErrMsg() );
        }
        if ( resTransret != null ) {
            payInGateOutput.setRetCode2( resTransret.getRetCode() );
            payInGateOutput.setRetMsg2( resTransret.getErrMsg() );
        }
        return ResponseUtils.success( payInGateOutput );
    }

    @Override
    public Response<PayInQueryGateOutput<Void>> payInQuery( PayInQueryGateInput payInQueryGateInput ) {

        ReqAipg200004 aipg200004 = new ReqAipg200004();
        ReqInfo200004 reqInfo200004 = new ReqInfo200004();
        reqInfo200004.setTrxCode( "200004" );
        reqInfo200004.setVersion( "04" );
        reqInfo200004.setDataType( "2" );
        reqInfo200004.setLevel( "5" );
        reqInfo200004.setMerchantId( merchantId );
        reqInfo200004.setUserName( userName );
        reqInfo200004.setUserPass( userPass );
        reqInfo200004.setReqSn( payInQueryGateInput.getOrderNo() );

        aipg200004.setInfo( reqInfo200004 );
        ReqQTransreq200004 qTransreq200004 = new ReqQTransreq200004();
        qTransreq200004.setMerchantId( merchantId );
        qTransreq200004.setQuerySn( payInQueryGateInput.getOrderNo() );
        aipg200004.setQtransreq( qTransreq200004 );

        //  原始字符串加签
        String xmlStr = XMLUtils.toString( aipg200004 );
        String signStr; //SM3withSM2 加签，使用老算法版本请联系开发者
        try {
            signStr = SignUtils.signXml( xmlStr, publicKey, privateKey );
        } catch ( NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e ) {
            logger.error( "通联支付签名失败" );
            return ResponseUtils.fail( "error", "签名失败" );
        }
        //  更新签名
        reqInfo200004.setSignedMsg( signStr );
        String reqXmlStr = XMLUtils.toString( aipg200004 );
        String resXmlStr;
        try {
            resXmlStr = HttpUtils.postXml( url, reqXmlStr );
        } catch ( IOException e ) {
            return ResponseUtils.fail( "error", "网络异常" );
        }
        ResAipg200004 resAipg200004 = XMLUtils.toObject( resXmlStr, ResAipg200004.class );
        ResInfo200004 resInfo200004 = resAipg200004.getInfo();
        List<ResQtdetail200004> resQtdetail200004s = resAipg200004.getQtdetail();

        if ( CollectionUtils.isEmpty( resQtdetail200004s ) ) {
            return ResponseUtils.fail( "error", "订单不存在" );
        }

        if ( resQtdetail200004s.size() != 1 ) {
            return ResponseUtils.fail( "error", "订单返回数量不正确" );
        }

        PayInQueryGateOutput<Void> payInQueryGateOutput = new PayInQueryGateOutput<>();
        if ( resInfo200004 != null ) {
            payInQueryGateOutput.setRetCode1( resInfo200004.getRetCode() );
            payInQueryGateOutput.setRetMsg1( resInfo200004.getSignedMsg() );
        }
        ResQtdetail200004 resQtdetail200004 = resQtdetail200004s.get( 0 );
        payInQueryGateOutput.setRetCode2( resQtdetail200004.getRetCode() );
        payInQueryGateOutput.setRetMsg2( resQtdetail200004.getErrMsg() );

        return ResponseUtils.success( payInQueryGateOutput );
    }
}
