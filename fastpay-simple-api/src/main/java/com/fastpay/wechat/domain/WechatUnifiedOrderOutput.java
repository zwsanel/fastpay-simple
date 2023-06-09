package com.fastpay.wechat.domain;

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
    private WechatPayRequest wechatPayRequest;

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

    public WechatPayRequest getWechatPayRequest() {
        return wechatPayRequest;
    }

    public void setWechatPayRequest( WechatPayRequest wechatPayRequest ) {
        this.wechatPayRequest = wechatPayRequest;
    }
}
