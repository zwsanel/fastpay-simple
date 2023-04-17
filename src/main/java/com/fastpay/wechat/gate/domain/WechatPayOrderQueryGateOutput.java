package com.fastpay.wechat.gate.domain;

public class WechatPayOrderQueryGateOutput {

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
     * 错误码
     */
    private String errCode;

    /**
     * 错误码描述
     */
    private String errCodeDes;

    /**
     * 微信订单号
     */
    private String transactionId;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 订单状态
     */
    private String tradeState;

    /**
     * 交易状态描述
     */
    private String tradeStateDesc;

    /**
     * 订单结束时间
     */
    private String timeEnd;

    /**
     * 付款银行
     */
    private String BankType;

    /**
     * 用户标识
     */
    private String openId;

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

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd( String timeEnd ) {
        this.timeEnd = timeEnd;
    }

    public String getBankType() {
        return BankType;
    }

    public void setBankType( String bankType ) {
        BankType = bankType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId( String openId ) {
        this.openId = openId;
    }
}
