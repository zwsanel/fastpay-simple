package com.fastpay.alipay.gate.domain;

public class AlipayTradeQueryGateOutput {

    /**
     * 支付宝交易号
     */
    private String tradeNo;

    /**
     * 商家订单号
     */
    private String outTradeNo;

    /**
     * 买家支付宝账号
     */
    private String buyerLogonId;

    /**
     * 交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款）
     */
    private String tradeStatus;

    /**
     * 交易的订单金额，单位为元，两位小数。该参数的值为支付时传入的total_amount
     */
    private String totalAmount;

    /**
     * 买家在支付宝的用户id
     */
    private String buyerUserId;

    /**
     * 网关返回码
     */
    private String code;

    /**
     * 网关返回码描述
     */
    private String msg;

    /**
     * 业务返回码
     */
    private String subCode;

    /**
     * 业务返回码描述
     */
    private String subMsg;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo( String tradeNo ) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo( String outTradeNo ) {
        this.outTradeNo = outTradeNo;
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount( String totalAmount ) {
        this.totalAmount = totalAmount;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId( String buyerUserId ) {
        this.buyerUserId = buyerUserId;
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode( String subCode ) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg( String subMsg ) {
        this.subMsg = subMsg;
    }
}
