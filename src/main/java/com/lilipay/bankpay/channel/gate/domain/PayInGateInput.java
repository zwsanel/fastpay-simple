package com.lilipay.bankpay.channel.gate.domain;

import java.math.BigDecimal;

public class PayInGateInput {

    /**
     * 商户流水号
     */
    private String requestNo;

    /**
     * 还款流水号
     */
    private String processNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 银行卡
     */
    private String cardNo;

    /**
     * 姓名
     */
    private String cardName;

    /**
     * 手机号
     */
    private String cardMobile;

    /**
     * 证件号
     */
    private String idNo;

    /**
     * 银行编码
     */
    private String bankCode;

    /**
     * 还款金额
     */
    private BigDecimal amount;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo( String processNo ) {
        this.processNo = processNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo( String cardNo ) {
        this.cardNo = cardNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName( String cardName ) {
        this.cardName = cardName;
    }

    public String getCardMobile() {
        return cardMobile;
    }

    public void setCardMobile( String cardMobile ) {
        this.cardMobile = cardMobile;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo( String idNo ) {
        this.idNo = idNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode( String bankCode ) {
        this.bankCode = bankCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }
}
