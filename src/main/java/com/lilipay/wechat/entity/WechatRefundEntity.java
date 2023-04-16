package com.lilipay.wechat.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 微信退款
 */
public class WechatRefundEntity {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 流水号
     */
    private String requestNo;

    /**
     * 处理号
     */
    private String processNo;

    /**
     * 原始订单流水
     */
    private String targetRequestNo;

    /**
     * 微信商户号
     */
    private String wechatMemberNo;

    /**
     * 退款单号
     */
    private String outRefundNo;

    /**
     * 退款金额
     */
    private BigDecimal refundFee;

    /**
     * 退款原因
     */
    private String refundDesc;

    /**
     * 返回状态码
     */
    private String returnCode;

    /**
     * 返回信息
     */
    private String returnMsg;

    /**
     * 返回码
     */
    private String resultCode;

    /**
     * 错误代码
     */
    private String errCode;

    /**
     * 错误代码描述
     */
    private String errCodeDes;

    /**
     * 微信退款单号
     */
    private String refundId;

    /**
     * 微信退款状态
     */
    private String refundStatus;

    /**
     * 退款状态
     */
    private String status;

    /**
     * 退款入账账户
     */
    private String refundRecvAccout;

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

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
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

    public String getTargetRequestNo() {
        return targetRequestNo;
    }

    public void setTargetRequestNo( String targetRequestNo ) {
        this.targetRequestNo = targetRequestNo;
    }

    public String getWechatMemberNo() {
        return wechatMemberNo;
    }

    public void setWechatMemberNo( String wechatMemberNo ) {
        this.wechatMemberNo = wechatMemberNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo( String outRefundNo ) {
        this.outRefundNo = outRefundNo;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee( BigDecimal refundFee ) {
        this.refundFee = refundFee;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc( String refundDesc ) {
        this.refundDesc = refundDesc;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode( String returnCode ) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg( String returnMsg ) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode( String resultCode ) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode( String errCode ) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes( String errCodeDes ) {
        this.errCodeDes = errCodeDes;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId( String refundId ) {
        this.refundId = refundId;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus( String refundStatus ) {
        this.refundStatus = refundStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getRefundRecvAccout() {
        return refundRecvAccout;
    }

    public void setRefundRecvAccout( String refundRecvAccout ) {
        this.refundRecvAccout = refundRecvAccout;
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