package com.lilipay.wechat.gateway.domain;

public class WechatCloseOrderGateInput {

    /**
     * 订单号
     */
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }
}
