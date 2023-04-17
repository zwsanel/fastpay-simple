package com.fastpay.wechat.gate.domain;

import java.math.BigDecimal;

public class WechatTransfersGateInput {

    /**
     * appid
     */
    private String appId;

    /**
     * 商户号
     */
    private String mchid;

    private String weixinHost;

    /**
     * 设备号
     */
    private String deviceInfo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * openId
     */
    private String openId;

    /**
     * 是否校验姓名
     */
    private Boolean checkName;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String desc;

    /**
     * ip
     */
    private String ip;

    /**
     * apikey
     */
    private String apiKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId( String openId ) {
        this.openId = openId;
    }

    public Boolean getCheckName() {
        return checkName;
    }

    public void setCheckName( Boolean checkName ) {
        this.checkName = checkName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc( String desc ) {
        this.desc = desc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp( String ip ) {
        this.ip = ip;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey( String apiKey ) {
        this.apiKey = apiKey;
    }

    public String getWeixinHost() {
        return weixinHost;
    }

    public void setWeixinHost( String weixinHost ) {
        this.weixinHost = weixinHost;
    }
}
