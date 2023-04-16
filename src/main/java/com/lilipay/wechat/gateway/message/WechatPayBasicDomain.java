package com.lilipay.wechat.gateway.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType( XmlAccessType.FIELD )
public class WechatPayBasicDomain {

    /**
     * 微信开放平台审核通过的应用APPID
     */
    private String appid;

    /**
     * 微信支付分配的商户号
     */
    @XmlElement( name = "mch_id" )
    private String mchId;


    /**
     * 随机字符串，不长于32位
     */
    @XmlElement( name = "nonce_str" )
    private String nonceStr;

    /**
     * 签名
     */
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

