package com.fastpay.wechat.domain;

import java.util.Date;

public class WechatOrderQueryOutput {

    /**
     * 商户流水号
     */
    private String requestNo;

    /**
     * 应用Id
     */
    private String appId;

    /**
     * 支付状态 PAYING: 支付中 SUCCESS: 成功 FAIL: 失败
     */
    private String status;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 渠道方订单号（微信）
     */
    private String channelOrderNo;

    /**
     * 回盘时间
     */
    private Date returnTime;

    /**
     * 微信支付时间
     */
    private Date payTime;

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

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo( String channelOrderNo ) {
        this.channelOrderNo = channelOrderNo;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime( Date returnTime ) {
        this.returnTime = returnTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime( Date payTime ) {
        this.payTime = payTime;
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
