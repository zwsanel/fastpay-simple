package com.fastpay.wechat.domain;

import java.math.BigDecimal;

public class WechatRefundInput {

    /**
     * 退款流水
     */

    private String requestNo;

    /**
     * 下单流水
     */

    private String targetRequestNo;

    /**
     * 退款金额
     */
    private BigDecimal amount;

    /**
     * 退款备注
     */
    private String refundDesc;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getTargetRequestNo() {
        return targetRequestNo;
    }

    public void setTargetRequestNo( String targetRequestNo ) {
        this.targetRequestNo = targetRequestNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc( String refundDesc ) {
        this.refundDesc = refundDesc;
    }
}
