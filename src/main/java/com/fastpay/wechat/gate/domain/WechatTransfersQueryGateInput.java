package com.fastpay.wechat.gate.domain;

public class WechatTransfersQueryGateInput {

    /**
     * appid
     */
    private String appId;

    /**
     * 商户号
     */
    private String mchid;

    private String weixinHost;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * apiKey
     */
    private String apiKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid( String mchid ) {
        this.mchid = mchid;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey( String apiKey ) {
        this.apiKey = apiKey;
    }

    public String getWeixinHost() {
        return weixinHost;
    }

    public void setWeixinHost( String weixinHost ) {
        this.weixinHost = weixinHost;
    }
}
