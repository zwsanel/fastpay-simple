package com.lilipay.wechat.gateway.domain;

public class WechatPayRefundGateOutput {

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
     * 微信退款单号
     */
    private String refundId;

    /**
     * 退款金额
     */
    private String refundFee;

    /**
     * 应结退款金额
     */
    private String settlementRefundFee;

    /**
     * 标价金额
     */
    private String totalFee;

    /**
     * 应结订单金额
     */
    private String settlementTotalFee;

    /**
     * 标价币种
     */
    private String feeType;

    /**
     * 现金支付金额
     */
    private String cashFee;

    /**
     * 现金支付币种
     */
    private String cashFeeType;

    /**
     * 现金退款金额
     */
    private String cashRefundFee;

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

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee( String refundFee ) {
        this.refundFee = refundFee;
    }

    public String getSettlementRefundFee() {
        return settlementRefundFee;
    }

    public void setSettlementRefundFee( String settlementRefundFee ) {
        this.settlementRefundFee = settlementRefundFee;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee( String totalFee ) {
        this.totalFee = totalFee;
    }

    public String getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee( String settlementTotalFee ) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType( String feeType ) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee( String cashFee ) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType( String cashFeeType ) {
        this.cashFeeType = cashFeeType;
    }

    public String getCashRefundFee() {
        return cashRefundFee;
    }

    public void setCashRefundFee( String cashRefundFee ) {
        this.cashRefundFee = cashRefundFee;
    }
}
