package com.lilipay.wechat.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 微信支付表
 */
public class WechatEntity {
    /**
     * 物理主键
     */
    private Long id;

    /**
     * 商户流水号
     */
    private String requestNo;

    /**
     * 流水号
     */
    private String processNo;

    /**
     * 微信商户号
     */
    private String wechatMemberNo;

    /**
     * 微信应用ID
     */
    private String appId;

    /**
     * 交易类型:JSAPI 小程序,MWEB h5支付，APP app支付,NATIVE 扫码支付
     */
    private String tradeType;

    /**
     * 支付结果通知队列名称
     */
    private String noticeQueue;

    /**
     * 扩展信息
     */
    private String extText1;

    /**
     * 产品编号,用于线下扫码支付
     */
    private String productId;

    /**
     * 支付url 扫码和h5支付使用
     */
    private String codeUrl;

    /**
     * h5支付唤起url
     */
    private String mwebUrl;

    /**
     * 支付场景，主要用于h5支付
     */
    private String sceneInfo;

    /**
     * 用户请求ip
     */
    private String requestIp;

    /**
     * 预付单
     */
    private String prepayId;

    /**
     * 商户订单号
     */
    private String orderNo;

    /**
     * 微信支付订单号
     */
    private String transactionId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单提交时间
     */
    private Date submitTime;

    /**
     * 订单失效时间
     */
    private Date expireTime;

    /**
     * 订单支付时间
     */
    private Date payTime;

    /**
     * 订单返回时间
     */
    private Date returnTime;

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
     * 用户在商户appid下的唯一标识
     */
    private String openId;

    /**
     * 付款银行
     */
    private String bankType;

    /**
     * 交易状态
     */
    private String tradeState;

    /**
     * 交易状态描述
     */
    private String tradeStateDesc;

    /**
     * 状态
     */
    private String status;

    /**
     * 交易限制，no_credit(不支持信用卡)，allow_credit(支持信用卡)
     */
    private String tradeLimit;

    /**
     * 交易描述
     */
    private String tradeDesc;

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

    public String getWechatMemberNo() {
        return wechatMemberNo;
    }

    public void setWechatMemberNo( String wechatMemberNo ) {
        this.wechatMemberNo = wechatMemberNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType( String tradeType ) {
        this.tradeType = tradeType;
    }

    public String getNoticeQueue() {
        return noticeQueue;
    }

    public void setNoticeQueue( String noticeQueue ) {
        this.noticeQueue = noticeQueue;
    }

    public String getExtText1() {
        return extText1;
    }

    public void setExtText1( String extText1 ) {
        this.extText1 = extText1;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId( String productId ) {
        this.productId = productId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl( String codeUrl ) {
        this.codeUrl = codeUrl;
    }

    public String getMwebUrl() {
        return mwebUrl;
    }

    public void setMwebUrl( String mwebUrl ) {
        this.mwebUrl = mwebUrl;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo( String sceneInfo ) {
        this.sceneInfo = sceneInfo;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp( String requestIp ) {
        this.requestIp = requestIp;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId( String prepayId ) {
        this.prepayId = prepayId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId( String transactionId ) {
        this.transactionId = transactionId;
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

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime( Date submitTime ) {
        this.submitTime = submitTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime( Date expireTime ) {
        this.expireTime = expireTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime( Date payTime ) {
        this.payTime = payTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime( Date returnTime ) {
        this.returnTime = returnTime;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId( String openId ) {
        this.openId = openId;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType( String bankType ) {
        this.bankType = bankType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState( String tradeState ) {
        this.tradeState = tradeState;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc( String tradeStateDesc ) {
        this.tradeStateDesc = tradeStateDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getTradeLimit() {
        return tradeLimit;
    }

    public void setTradeLimit( String tradeLimit ) {
        this.tradeLimit = tradeLimit;
    }

    public String getTradeDesc() {
        return tradeDesc;
    }

    public void setTradeDesc( String tradeDesc ) {
        this.tradeDesc = tradeDesc;
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