package com.lilipay.wechat.gate.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( value = XmlAccessType.FIELD )
public class WechatCloseOrderInputXml {

    /**
     * 应用ID
     */
    @XmlElement( name = "appid" )
    private String appid;

    /**
     * 商户号
     */
    @XmlElement( name = "mch_id" )
    private String mchId;

    /**
     * 商户订单号
     */
    @XmlElement( name = "out_trade_no" )
    private String outTradeNo;

    /**
     * 随机字符串
     */
    @XmlElement( name = "nonce_str" )
    private String nonceStr;

    /**
     * 签名
     */
    @XmlElement( name = "sign" )
    private String sign;

    public String getAppid() {
        return appid;
    }

    public void setAppid( String appid ) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId( String mchId ) {
        this.mchId = mchId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo( String outTradeNo ) {
        this.outTradeNo = outTradeNo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr( String nonceStr ) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }
}
