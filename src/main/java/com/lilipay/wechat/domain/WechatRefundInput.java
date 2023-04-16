package com.lilipay.wechat.domain;

import java.math.BigDecimal;

public class WechatRefundInput {

    /**
     * 退款流水号
     */

    private String requestNo;

    /**
     * 微信统一下单流水号
     */

    private String unifiedOrderRequestNo;

    /**
     * 退款金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 通知URL
     */
    private String notifyUrl;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getUnifiedOrderRequestNo() {
        return unifiedOrderRequestNo;
    }

    public void setUnifiedOrderRequestNo( String unifiedOrderRequestNo ) {
        this.unifiedOrderRequestNo = unifiedOrderRequestNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl( String notifyUrl ) {
        this.notifyUrl = notifyUrl;
    }
}
