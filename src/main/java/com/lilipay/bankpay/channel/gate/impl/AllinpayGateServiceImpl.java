package com.lilipay.bankpay.channel.gate.impl;

import com.lilipay.bankpay.channel.gate.AllinpayGateService;
import com.lilipay.bankpay.channel.gate.domain.PayInGateInput;
import com.lilipay.bankpay.channel.gate.domain.PayInQueryGateInput;
import com.lilipay.bankpay.channel.gate.domain.PayInQueryGateOutput;
import com.lilipay.bankpay.channel.gate.message.m100011.ReqAipg;
import com.lilipay.bankpay.channel.gate.message.m100011.ReqInfo;
import com.lilipay.bankpay.channel.gate.message.m100011.ReqTrans;
import com.lilipay.bankpay.channel.gate.message.m100011.ResAipg;
import com.lilipay.bankpay.channel.gate.utils.HttpUtils;
import com.lilipay.bankpay.channel.gate.utils.SignUtils;
import com.lilipay.bankpay.domain.PayInQueryRequest;
import com.lilipay.bankpay.domain.PayInQueryResult;
import com.lilipay.bankpay.domain.PayInRequest;
import com.lilipay.bankpay.domain.PayInResult;
import com.lilipay.common.Response;
import com.lilipay.common.ResponseUtils;
import com.lilipay.common.utils.XMLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static com.lilipay.common.Constants.ALLINPAY_DATE_PATTERN;

@Service
public class AllinpayGateServiceImpl implements AllinpayGateService {

    private static final Logger logger = LogManager.getLogger( AllinpayGateServiceImpl.class );

    //商户号
    private String merchantId;

    //用户名
    private String userName;

    //用户密码
    private String userPass;

    //业务代码
    private String businessCode;

    //通知地址
    private String notifyUrl;

    private String publicKey;

    private String privateKey;

    private String url;

    @Override
    public Response<PayInQueryGateInput> payIn( PayInGateInput payInGateInput ) {
        ReqAipg aipg = new ReqAipg();
        ReqInfo info = new ReqInfo();
        info.setTrxCode( "100011" );
        info.setVersion( "05" );
        info.setDataType( "2" );
        info.setLevel( "5" );
        info.setMerchantId( merchantId );
        info.setUserName( userName );
        info.setUserPass( userPass );
        info.setReqSn( payInGateInput.getOrderNo() );
        aipg.setInfo( info );
        ReqTrans trans = new ReqTrans();
        trans.setBusinessCode( businessCode );
        trans.setMerchantId( merchantId );
        trans.setSubmitTime( DateTimeFormatter.ofPattern( ALLINPAY_DATE_PATTERN ).format( LocalDateTime.now().atZone( ZoneOffset.systemDefault() ) ) );
        trans.setAccountType( "00" );
        trans.setBankCode( payInGateInput.getBankCode() );
        trans.setAccountNo( payInGateInput.getCardNo() );
        trans.setAccountName( payInGateInput.getCardName() );
        trans.setAmount( payInGateInput.getAmount().movePointRight( 2 ).toString() );
        trans.setCurrency( "CNY" );
        trans.setIdType( "0" );
        trans.setId( payInGateInput.getIdNo() );
        trans.setTel( payInGateInput.getCardMobile() );
        trans.setNotifyUrl( notifyUrl );
        aipg.setTrans( trans );
        //  原始字符串加签
        String xmlStr = XMLUtils.toString( aipg );
        String signStr = null; //SM3withSM2 加签，使用老算法版本请联系开发者
        try {
            signStr = SignUtils.signXml( xmlStr, publicKey, privateKey );
        } catch ( NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e ) {
            logger.error( "通联支付签名失败" );
            return ResponseUtils.fail( "error", "签名失败" );
        }
        //  更新签名
        info.setSignedMsg( signStr );
        String reqXmlStr = XMLUtils.toString( aipg );
        String resXmlStr = null;
        try {
            resXmlStr = HttpUtils.postXml( url, reqXmlStr );
        } catch ( IOException e ) {
            return ResponseUtils.fail( "error", "网络异常" );
        }
        ResAipg resAipg = XMLUtils.toObject( resXmlStr, ResAipg.class );

        return null;
    }

    @Override
    public Response<PayInQueryGateOutput> payInQuery( PayInQueryGateInput payInQueryGateInput ) {
        return null;
    }
}
