package com.fastpay.wechat.gate.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType( value = XmlAccessType.FIELD )
@XmlRootElement( name = "xml" )
public class WechatAppPayOutput {
    /**
     * 应用ID
     */
    @XmlElement( name = "appid" )
    private String appId;
    /**
     * 商户号
     */
    @XmlElement( name = "partnerid" )
    private String partnerId;
    /**
     * 预支付交易会话ID
     */
    @XmlElement( name = "prepayid" )
    private String prepayId;
    /**
     * 扩展字段
     */
    @XmlElement( name = "package" )
    private String wxPackage;
    /**
     * 随机字符串
     */
    @XmlElement( name = "noncestr" )
    private String nonceStr;
    /**
     * 时间戳
     */
    @XmlElement( name = "timestamp" )
    private String timeStamp;
    /**
     * 签名
     */
    @XmlElement( name = "sign" )
    private String sign;

    private String signType;

    public String getSignType() {
        return signType;
    }

    public void setSignType( String signType ) {
        this.signType = signType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId( String partnerId ) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId( String prepayId ) {
        this.prepayId = prepayId;
    }

    public String getWxPackage() {
        return wxPackage;
    }

    public void setWxPackage( String wxPackage ) {
        this.wxPackage = wxPackage;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr( String nonceStr ) {
        this.nonceStr = nonceStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp( String timeStamp ) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }
}
