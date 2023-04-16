package com.lilipay.wechat.domain;

import java.math.BigDecimal;

public class WechatUnifiedOrderInput {

    /**
     * 商户号
     */
    private String memberNo;

    /**
     * 微信分配的appId
     */
    private String appId = "";

    /**
     * 交易类型
     * JSAPI：小程序支付/扫码支付
     * MWEB：h5网页支付
     * APP：app支付 （不传默认app支付）
     * NATIVE：扫码支付
     */
    private String tradeType = "APP";

    /**
     * 用户在商户appid下的唯一标识，交易类型为JSAPI必传
     */
    private String openId = "";

    /**
     * 商户流水号
     */
    private String requestNo;

    /**
     * 用户真实ip地址
     */
    private String requestIp;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 订单有效期 (分钟)
     */
    private Integer effectiveTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 交易描述
     */
    private String tradeDesc;

    /**
     * 交易限制，no_credit (不支持信用卡),allow_credit(支持信用卡)
     */
    private String tradeLimit;

    /**
     * 结果通知队列名称 不传或者传空则不通知
     */
    private String noticeQueue;

    /**
     * 通知类型 {@link com.qihoo.finance.pcs.weixin.constants.WeixinNotifyType}
     */
    private String notifyType;

    /**
     * 通知地址
     */
    private String notifyValue;

    /**
     * 支付场景
     */
    private WechatSceneInfo sceneInfo;

    /**
     * 产品编号  用于线下扫码支付
     */
    private String productId;

    /**
     * 扩展字段1
     */
    private String extText1;

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

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType( String tradeType ) {
        this.tradeType = tradeType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId( String openId ) {
        this.openId = openId;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp( String requestIp ) {
        this.requestIp = requestIp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }

    public Integer getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime( Integer effectiveTime ) {
        this.effectiveTime = effectiveTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }

    public String getTradeDesc() {
        return tradeDesc;
    }

    public void setTradeDesc( String tradeDesc ) {
        this.tradeDesc = tradeDesc;
    }

    public String getTradeLimit() {
        return tradeLimit;
    }

    public void setTradeLimit( String tradeLimit ) {
        this.tradeLimit = tradeLimit;
    }

    public String getNoticeQueue() {
        return noticeQueue;
    }

    public void setNoticeQueue( String noticeQueue ) {
        this.noticeQueue = noticeQueue;
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

    public WechatSceneInfo getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo( WechatSceneInfo sceneInfo ) {
        this.sceneInfo = sceneInfo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId( String productId ) {
        this.productId = productId;
    }

    public String getExtText1() {
        return extText1;
    }

    public void setExtText1( String extText1 ) {
        this.extText1 = extText1;
    }
}
