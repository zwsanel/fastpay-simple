package com.lilipay.wechat.domain;

import java.util.Date;

public class WechatTransferOutput {

    /**
     * 请求流水号
     */
    private String requestNo;

    /**
     * 付款结果
     */
    private String status;

    /**
     * 错误代码
     */
    private String errCode;

    /**
     * 错误代码描述
     */
    private String errCodeDes;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 微信付款单号
     */
    private String paymentNo;

    /**
     * 微信付款成功时间
     */
    private Date paymentTime;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo( String paymentNo ) {
        this.paymentNo = paymentNo;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime( Date paymentTime ) {
        this.paymentTime = paymentTime;
    }
}
