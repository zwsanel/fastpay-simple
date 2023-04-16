package com.lilipay.wechat.domain;

public class WeixinPayRequest  {

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 商户号
     */
    private String partnerId;

    /**
     * 预支付交易会话ID
     */
    private String prepayId;

    /**
     * 随机字符串
     */
    private String nonceStr;

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 签名
     */
    private String sign;

    /**
     * 扩展字段
     */
    private String packageStr;

    /**
     * 签名类型，默认为MD5，支持HMAC-SHA256和MD5。注意此处需与统一下单的签名类型一致
     */
    private String signType;

    /**
     * 扫码支付链接
     */
    private String codeUrl;

    /**
     * h5支付链接
     */
    private String mwebUrl;

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

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr( String nonceStr ) {
        this.nonceStr = nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp( String timestamp ) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }

    public String getPackageStr() {
        return packageStr;
    }

    public void setPackageStr( String packageStr ) {
        this.packageStr = packageStr;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl( String codeUrl ) {
        this.codeUrl = codeUrl;
    }

    public String getMwebUrl() {
        return mwebUrl;
    }

    public void setMwebUrl( String mwebUrl ) {
        this.mwebUrl = mwebUrl;
    }
}
