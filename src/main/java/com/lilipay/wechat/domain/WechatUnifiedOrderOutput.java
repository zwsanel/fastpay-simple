package com.lilipay.wechat.domain;

public class WechatUnifiedOrderOutput {

    /**
     * 请求流水号
     */
    private String requestNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 调起支付请求参数
     */
    private WeixinPayRequest weixinPayRequest;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public WeixinPayRequest getWeixinPayRequest() {
        return weixinPayRequest;
    }

    public void setWeixinPayRequest( WeixinPayRequest weixinPayRequest ) {
        this.weixinPayRequest = weixinPayRequest;
    }
}
