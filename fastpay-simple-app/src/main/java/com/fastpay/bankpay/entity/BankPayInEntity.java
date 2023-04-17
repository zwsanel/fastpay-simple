package com.fastpay.bankpay.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 银行卡收款
 */
public class BankPayInEntity {
    /**
     * 物理主键
     */
    private Long id;

    /**
     * 商户流水号
     */
    private String requestNo;

    /**
     * 还款流水号
     */
    private String processNo;

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

    /**
     * 处理状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date dateCreated;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 修改时间
     */
    private Date dateUpdated;

    /**
     * 修改人
     */
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated( Date dateCreated ) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy( String createdBy ) {
        this.createdBy = createdBy;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated( Date dateUpdated ) {
        this.dateUpdated = dateUpdated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy( String updatedBy ) {
        this.updatedBy = updatedBy;
    }
}