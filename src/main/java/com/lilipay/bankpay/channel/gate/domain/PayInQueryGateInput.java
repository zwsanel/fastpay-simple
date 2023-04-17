package com.lilipay.bankpay.channel.gate.domain;

public class PayInQueryGateInput {

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
