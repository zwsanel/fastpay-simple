package com.fastpay.wechat.gate.domain;

public class WechatPayRefundQueryGateOutput {

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
     * 错误码
     */
    private String errCode;

    /**
     * 错误描述
     */
    private String errCodeDes;

    /**
     * 订单总退款次数
     */
    private Integer totalRefundCount;

    /**
     * 微信订单号
     */
    private String transactionId;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 订单金额
     */
    private Integer totalFee;

    /**
     * 应结订单金额
     */
    private Integer settlementTotalFee;

    /**
     * 货币种类
     */
    private String feeType;

    /**
     * 现金支付金额
     */
    private Integer cashFee;

    /**
     * 退款笔数
     */
    private Integer refundCount;

    /**
     * 商户退款单号
     */
    private String outRefundNo;

    /**
     * 微信退款单号
     */
    private String refundId;

    /**
     * 退款渠道
     */
    private String refundChannel;

    /**
     * 申请退款金额
     */
    private Integer refundFee;

    /**
     * 退款金额
     */
    private Integer settlementRefundFee;

    /**
     * 总代金券退款金额
     */
    private Integer couponRefundFee;

    /**
     * 退款状态
     */
    private String refundStatus;

    /**
     * 退款资金来源
     */
    private String refundAccount;

    /**
     * 退款入账账户
     */
    private String refundRecvAccout;

    /**
     * 退款成功时间
     */
    private String refundSuccessTime;

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

    public Integer getTotalRefundCount() {
        return totalRefundCount;
    }

    public void setTotalRefundCount( Integer totalRefundCount ) {
        this.totalRefundCount = totalRefundCount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId( String transactionId ) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo( String outTradeNo ) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee( Integer totalFee ) {
        this.totalFee = totalFee;
    }

    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee( Integer settlementTotalFee ) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType( String feeType ) {
        this.feeType = feeType;
    }

    public Integer getCashFee() {
        return cashFee;
    }

    public void setCashFee( Integer cashFee ) {
        this.cashFee = cashFee;
    }

    public Integer getRefundCount() {
        return refundCount;
    }

    public void setRefundCount( Integer refundCount ) {
        this.refundCount = refundCount;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo( String outRefundNo ) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId( String refundId ) {
        this.refundId = refundId;
    }

    public String getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel( String refundChannel ) {
        this.refundChannel = refundChannel;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee( Integer refundFee ) {
        this.refundFee = refundFee;
    }

    public Integer getSettlementRefundFee() {
        return settlementRefundFee;
    }

    public void setSettlementRefundFee( Integer settlementRefundFee ) {
        this.settlementRefundFee = settlementRefundFee;
    }

    public Integer getCouponRefundFee() {
        return couponRefundFee;
    }

    public void setCouponRefundFee( Integer couponRefundFee ) {
        this.couponRefundFee = couponRefundFee;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus( String refundStatus ) {
        this.refundStatus = refundStatus;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount( String refundAccount ) {
        this.refundAccount = refundAccount;
    }

    public String getRefundRecvAccout() {
        return refundRecvAccout;
    }

    public void setRefundRecvAccout( String refundRecvAccout ) {
        this.refundRecvAccout = refundRecvAccout;
    }

    public String getRefundSuccessTime() {
        return refundSuccessTime;
    }

    public void setRefundSuccessTime( String refundSuccessTime ) {
        this.refundSuccessTime = refundSuccessTime;
    }
}
