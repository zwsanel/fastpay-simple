package com.fastpay.wechat.gate.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( value = XmlAccessType.FIELD )
public class WechatJsapiResignDomain {

    @XmlElement( name = "appId" )
    private String appid;

    @XmlElement( name = "timeStamp" )
    private String timeStamp;

    @XmlElement( name = "nonceStr" )
    private String nonceStr;

    @XmlElement( name = "package" )
    private String wxPackage;

    @XmlElement( name = "signType" )
    private String signType;

    public String getAppid() {
        return appid;
    }

    public void setAppid( String appid ) {
        this.appid = appid;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp( String timeStamp ) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr( String nonceStr ) {
        this.nonceStr = nonceStr;
    }

    public String getWxPackage() {
        return wxPackage;
    }

    public void setWxPackage( String wxPackage ) {
        this.wxPackage = wxPackage;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType( String signType ) {
        this.signType = signType;
    }
}
