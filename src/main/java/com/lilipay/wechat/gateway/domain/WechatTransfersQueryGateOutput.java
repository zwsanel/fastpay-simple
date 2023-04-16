package com.lilipay.wechat.gateway.domain;

public class WechatTransfersQueryGateOutput {

    /**
     * 返回状态码
     */
    private String returnCode;

    /**
     * 返回信息
     */
    private String returnMsg;

    /**
     * 业务结果
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
     * 商户单号
     */
    private String partnerTradeNo;

    /**
     * Appid
     */
    private String appid;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 付款单号
     */
    private String detailId;

    /**
     * 转账状态
     */
    private String status;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 收款用户openid
     */
    private String openid;

    /**
     * 收款用户姓名
     */
    private String transferName;

    /**
     * 付款金额
     */
    private String paymentAmount;

    /**
     * 转账时间
     */
    private String transferTime;

    /**
     * 付款成功时间
     */
    private String paymentTime;

    /**
     * 企业付款备注
     */
    private String desc;

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

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo( String partnerTradeNo ) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid( String appid ) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId( String mchId ) {
        this.mchId = mchId;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId( String detailId ) {
        this.detailId = detailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason( String reason ) {
        this.reason = reason;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid( String openid ) {
        this.openid = openid;
    }

    public String getTransferName() {
        return transferName;
    }

    public void setTransferName( String transferName ) {
        this.transferName = transferName;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount( String paymentAmount ) {
        this.paymentAmount = paymentAmount;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime( String transferTime ) {
        this.transferTime = transferTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime( String paymentTime ) {
        this.paymentTime = paymentTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc( String desc ) {
        this.desc = desc;
    }
}
