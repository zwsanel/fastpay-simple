package com.lilipay.wechat.domain;

import java.math.BigDecimal;
import java.util.Date;

public class WechatResultResponse {

    /**
     * 请求流水号
     */
    private String requestNo;

    /**
     * 商户号
     */
    private String memberNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     *
     */
    private String channelOrderNo;

    /**
     * 代扣状态
     */
    private String status;

    /**
     * 代扣成功金额
     */
    private BigDecimal amount;

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

    /**
     * 扩展字段1
     */
    private String extText1;

    /**
     * 微信商户号
     */
    private String channelMemberNo;

    /**
     * 应用Id
     */
    private String appId;

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime( Date payTime ) {
        this.payTime = payTime;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo( String channelOrderNo ) {
        this.channelOrderNo = channelOrderNo;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo( String memberNo ) {
        this.memberNo = memberNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime( Date returnTime ) {
        this.returnTime = returnTime;
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

    public String getExtText1() {
        return extText1;
    }

    public void setExtText1( String extText1 ) {
        this.extText1 = extText1;
    }

    public String getChannelMemberNo() {
        return channelMemberNo;
    }

    public void setChannelMemberNo( String channelMemberNo ) {
        this.channelMemberNo = channelMemberNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }
}
