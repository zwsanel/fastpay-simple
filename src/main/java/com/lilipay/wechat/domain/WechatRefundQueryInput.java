package com.lilipay.wechat.domain;

public class WechatRefundQueryInput {

    /**
     * 退款流水号
     */
    private String requestNo;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }
}
