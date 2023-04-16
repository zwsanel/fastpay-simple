package com.lilipay.wechat.domain;

public class WechatPrepayQueryOutput {

    /**
     * 请求流水号
     */
    private String requestNo;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 调起支付请求参数
     */
    private WechatPayRequest weixinPayRequest;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public WechatPayRequest getWeixinPayRequest() {
        return weixinPayRequest;
    }

    public void setWeixinPayRequest( WechatPayRequest weixinPayRequest ) {
        this.weixinPayRequest = weixinPayRequest;
    }
}
