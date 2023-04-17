package com.fastpay.wechat.gate.domain;

public class WechatPayUnifiedOrderGateOutput {

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
     * 预支付交易会话标识
     */
    private String prepayId;

    /**
     * 二维码支付地址
     */
    private String codeUrl;

    /**
     * h5支付地址
     */
    private String mwebUrl;

    /**
     * 微信app端支付参数
     */
    private WechatAppPayOutput appPayRequest;

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

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId( String prepayId ) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl( String codeUrl ) {
        this.codeUrl = codeUrl;
    }

    public String getMwebUrl() {
        return mwebUrl;
    }

    public void setMwebUrl( String mwebUrl ) {
        this.mwebUrl = mwebUrl;
    }

    public WechatAppPayOutput getAppPayRequest() {
        return appPayRequest;
    }

    public void setAppPayRequest( WechatAppPayOutput appPayRequest ) {
        this.appPayRequest = appPayRequest;
    }
}
