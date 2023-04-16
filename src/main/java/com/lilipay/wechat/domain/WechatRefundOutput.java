package com.lilipay.wechat.domain;

import java.util.Date;

public class WechatRefundOutput {

    /**
     * 流水号
     */
    private String requestNo;

    /**
     * 微信退款单号
     */
    private String wechatRefundNo;

    /**
     * 退款状态
     */
    private String status;

    /**
     * 退款成功时间
     */
    private Date successTime;

    /**
     * 退款入账账户
     */
    private String recvAccout;

    /**
     * 错误码
     */
    private String errCode;

    /**
     * 错误码描述
     */
    private String errCodeDesc;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getWechatRefundNo() {
        return wechatRefundNo;
    }

    public void setWechatRefundNo( String wechatRefundNo ) {
        this.wechatRefundNo = wechatRefundNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime( Date successTime ) {
        this.successTime = successTime;
    }

    public String getRecvAccout() {
        return recvAccout;
    }

    public void setRecvAccout( String recvAccout ) {
        this.recvAccout = recvAccout;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode( String errCode ) {
        this.errCode = errCode;
    }

    public String getErrCodeDesc() {
        return errCodeDesc;
    }

    public void setErrCodeDesc( String errCodeDesc ) {
        this.errCodeDesc = errCodeDesc;
    }
}
