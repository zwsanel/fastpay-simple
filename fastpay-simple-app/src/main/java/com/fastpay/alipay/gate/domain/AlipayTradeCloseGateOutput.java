package com.fastpay.alipay.gate.domain;

public class AlipayTradeCloseGateOutput {

    /**
     * 支付宝交易号
     */
    private String tradeNo;

    /**
     * 创建交易传入的商户订单号
     */
    private String outTradeNo;

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
