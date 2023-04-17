package com.fastpay.wechat.domain;

public class WechatPrepayQueryInput {

    /**
     * 请求流水号
     */
    private String requestNo;

    /**
     * 预支付ID
     */
    private String prepayId;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId( String prepayId ) {
        this.prepayId = prepayId;
    }
}
