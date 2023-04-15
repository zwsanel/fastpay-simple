package com.lilipay.alipay.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AlipayAppEntity {
    /**
     * 物理主键
     */
    private Long id;

    /**
     * 商户流水号
     */
    private String requestNo;

    /**
     * 业务流水号
     */
    private String processNo;

    /**
     * 支付宝APPID
     */
    private String appId;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 订单总金额，单位为元，精确到小数点后两位
     */
    private BigDecimal totalAmount;

    /**
     * 该笔订单允许的最晚付款时间，逾期将关闭交易，超时关闭交易无法继续付款
     */
    private String timeoutExpress;

    /**
     * 绝对超时时间，格式为yyyy-MM-dd HH:mm
     */
    private String timeExpire;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 支付宝交易号
     */
    private String tradeNo;

    /**
     * 买家支付宝账号
     */
    private String buyerLogonId;

    /**
     * 交易状态
     */
    private String tradeStatus;

    /**
     * 买家在支付宝的用户id
     */
    private String buyerUserId;

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

    /**
     * 订单描述
     */
    private String body;

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

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo( String outTradeNo ) {
        this.outTradeNo = outTradeNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject( String subject ) {
        this.subject = subject;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount( BigDecimal totalAmount ) {
        this.totalAmount = totalAmount;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress( String timeoutExpress ) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire( String timeExpire ) {
        this.timeExpire = timeExpire;
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

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId( String buyerLogonId ) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus( String tradeStatus ) {
        this.tradeStatus = tradeStatus;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId( String buyerUserId ) {
        this.buyerUserId = buyerUserId;
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

    public String getBody() {
        return body;
    }

    public void setBody( String body ) {
        this.body = body;
    }
}