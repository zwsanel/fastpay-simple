package com.lilipay.alipay.domain;

public class AlipayAppPayTradeOutput {

    /**
     * 商户流水号
     */
    private String requestNo;

    /**
     * 支付状态
     */
    private String status;

    /**
     * 支付宝订单号
     */
    private String tradeNo;

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo( String tradeNo ) {
        this.tradeNo = tradeNo;
    }
}
