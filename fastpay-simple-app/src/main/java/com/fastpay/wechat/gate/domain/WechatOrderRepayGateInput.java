package com.fastpay.wechat.gate.domain;

public class WechatOrderRepayGateInput {

    /**
     * 微信交易类型
     */
    private String tradeType;
    /**
     * 预付单号
     */
    private String prepayId;
    /**
     * 微信应用ID
     */
    private String appId;
    /**
     * 微信商户ID
     */
    private String mchId;

    /**
     * 微信验签秘钥
     */
    private String key;

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType( String tradeType ) {
        this.tradeType = tradeType;
    }

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId( String prepayId ) {
        this.prepayId = prepayId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId( String mchId ) {
        this.mchId = mchId;
    }
}
