package com.fastpay.wechat.domain;

import java.math.BigDecimal;

public class WechatTransferInput {

    /**
     * 业务流水号
     */
    private String requestNo;

    /**
     * 商户号
     */
    private String memberNo;

    /**
     * appId
     */
    private String appId;

    /**
     * openId
     */
    private String openId;

    /**
     * 设备号
     */
    private String deviceInfo;

    /**
     * 是否校验用户姓名
     */
    private Boolean checkName;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 付款金额
     */
    private BigDecimal amount;

    /**
     * 付款备注
     */
    private String desc;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 通知类型
     */
    private String notifyType;

    /**
     * 通知地址
     */
    private String notifyValue;

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

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId( String openId ) {
        this.openId = openId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo( String deviceInfo ) {
        this.deviceInfo = deviceInfo;
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

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType( String notifyType ) {
        this.notifyType = notifyType;
    }

    public String getNotifyValue() {
        return notifyValue;
    }

    public void setNotifyValue( String notifyValue ) {
        this.notifyValue = notifyValue;
    }
}
