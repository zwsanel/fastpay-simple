package com.lilipay.wechat.gateway.domain;

public class WechatPayRefundNoticeGateOutput {

    /**
     * 返回状态码
     */
    private String returnCode;

    /**
     * 返回信息
     */
    private String returnMsg;

    /**
     * 微信订单号
     */
    private String transactionId;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 微信退款单号
     */
    private String refundId;

    /**
     * 商户退款单号
     */
    private String outRefundNo;

    /**
     * 订单金额
     */
    private Integer totalFee;

    /**
     * 应结订单金额
     */
    private Integer settlementTotalFee;

    /**
     * 申请退款金额
     */
    private Integer refundFee;

    /**
     * 退款金额
     */
    private Integer settlementRefundFee;

    /**
     * 退款状态
     */
    private String refundStatus;

    /**
     * 退款成功时间
     */
    private String successTime;

    /**
     * 退款入账账户
     */
    private String refundRecvAccout;

    /**
     * 退款资金来源
     */
    private String refundAccount;

    /**
     * 退款发起来源
     */
    private String refundRequestSource;

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

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId( String refundId ) {
        this.refundId = refundId;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo( String outRefundNo ) {
        this.outRefundNo = outRefundNo;
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

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus( String refundStatus ) {
        this.refundStatus = refundStatus;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime( String successTime ) {
        this.successTime = successTime;
    }

    public String getRefundRecvAccout() {
        return refundRecvAccout;
    }

    public void setRefundRecvAccout( String refundRecvAccout ) {
        this.refundRecvAccout = refundRecvAccout;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount( String refundAccount ) {
        this.refundAccount = refundAccount;
    }

    public String getRefundRequestSource() {
        return refundRequestSource;
    }

    public void setRefundRequestSource( String refundRequestSource ) {
        this.refundRequestSource = refundRequestSource;
    }
}
