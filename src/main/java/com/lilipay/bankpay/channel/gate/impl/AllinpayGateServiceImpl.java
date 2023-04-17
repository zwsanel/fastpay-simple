package com.lilipay.bankpay.channel.gate.impl;

import com.lilipay.bankpay.channel.gate.AllinpayGateService;
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
import com.lilipay.common.utils.XMLUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static com.lilipay.common.Constants.ALLINPAY_DATE_PATTERN;

@Service
public class AllinpayGateServiceImpl implements AllinpayGateService {

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
    public Response<PayInResult> payIn( PayInRequest payInRequest ) {
        ReqAipg aipg = new ReqAipg();
        ReqInfo info = new ReqInfo();
        info.setTrxCode( "100011" );
        info.setVersion( "05" );
        info.setDataType( "2" );
        info.setLevel( "5" );
        info.setMerchantId( merchantId );
        info.setUserName( userName );
        info.setUserPass( userPass );
        info.setReqSn();
        aipg.setInfo( info );
        ReqTrans trans = new ReqTrans();
        trans.setBusinessCode( businessCode );
        trans.setMerchantId( merchantId );
        trans.setSubmitTime( DateTimeFormatter.ofPattern( ALLINPAY_DATE_PATTERN ).format( LocalDateTime.now().atZone( ZoneOffset.systemDefault() ) ) );
        trans.setAccountType( "00" );
        trans.setBankCode( payInRequest.getBankCode() );
        trans.setAccountNo( payInRequest.getCardNo() );
        trans.setAccountName( payInRequest.getCardName() );
        trans.setAmount( payInRequest.getAmount().movePointRight( 2 ).toString() );
        trans.setCurrency( "CNY" );
        trans.setIdType( "0" );
        trans.setId( payInRequest.getIdNo() );
        trans.setTel( payInRequest.getCardMobile() );
        trans.setNotifyUrl( notifyUrl );
        aipg.setTrans( trans );
        //  原始字符串加签
        String xmlStr = XMLUtils.toString( aipg );
        String signStr = SignUtils.signXml( xmlStr, publicKey, privateKey ); //SM3withSM2 加签，使用老算法版本请联系开发者
        //  更新签名
        info.setSignedMsg( signStr );
        String reqXmlStr = XMLUtils.toString( aipg );
        String resXmlStr = HttpUtils.postXml( url, reqXmlStr );
        ResAipg resAipg = XMLUtils.toObject( resXmlStr, ResAipg.class );

        return null;
    }

    @Override
    public Response<PayInQueryResult> payInQuery( PayInQueryRequest payInQueryRequest ) {
        return null;
    }
}
