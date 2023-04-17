package com.lilipay.alipay.gate.domain;

public class AlipayAppPayGateOutput {

    /**
     * 唤起支付宝SDK所需的订单信息
     */
    private String orderInfo;

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

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo( String orderInfo ) {
        this.orderInfo = orderInfo;
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
