package com.lilipay.wechat.gate.domain;

public class WechatTransfersGateOutput {

    /**
     * 返回状态码
     */
    private String returnCode;

    /**
     * 返回信息
     */
    private String returnMsg;

    /**
     * 商户appid
     */
    private String mchAppid;

    /**
     * 商户号
     */
    private String mchid;

    /**
     * 设备号
     */
    private String deviceInfo;

    /**
     * 随机字符串
     */
    private String nonceStr;

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
     * 商户订单号
     */
    private String partnerTradeNo;

    /**
     * 微信付款单号
     */
    private String paymentNo;

    /**
     * 付款成功时间
     */
    private String paymentTime;

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

    public String getMchAppid() {
        return mchAppid;
    }

    public void setMchAppid( String mchAppid ) {
        this.mchAppid = mchAppid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid( String mchid ) {
        this.mchid = mchid;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo( String deviceInfo ) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr( String nonceStr ) {
        this.nonceStr = nonceStr;
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

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo( String paymentNo ) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime( String paymentTime ) {
        this.paymentTime = paymentTime;
    }
}
