package com.lilipay.wechat.gate.domain;

public class WechatPayRefundQueryGateInput {

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * apiKey
     */
    private String apiKey;

    private String weixinHost;

    /**
     * 微信订单号
     */
    private String transactionId;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 商户退款单号
     */
    private String outRefundNo;

    /**
     * 微信退款单号
     */
    private String refundId;

    /**
     * 偏移量
     */
    private Integer offset;

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

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey( String apiKey ) {
        this.apiKey = apiKey;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId( String transactionId ) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo( String outTradeNo ) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo( String outRefundNo ) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId( String refundId ) {
        this.refundId = refundId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset( Integer offset ) {
        this.offset = offset;
    }

    public String getWeixinHost() {
        return weixinHost;
    }

    public void setWeixinHost( String weixinHost ) {
        this.weixinHost = weixinHost;
    }
}
