package com.lilipay.wechat.gateway.domain;

public class WechatPayUnifiedOrderGateInput {

    /**
     * 商品描述
     */
    private String body;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 扣款金额
     */
    private String amount;

    /**
     * 用户真实IP
     */
    private String requestIp;

    /**
     * 交易起始时间
     */
    private String beginTime;

    /**
     * 交易结束时间
     */
    private String endTime;

    /**
     * 交易限制，是否信用卡支付
     */
    private String tradeLimit;

    /**
     * 交易类型
     * JSAPI：小程序支付/扫码支付
     * MWEB：h5网页支付
     * APP：app支付 （不传默认app支付）
     * NATIVE：扫码支付
     */
    private String tradeType;

    /**
     * 用户在商户appid下的唯一标识，交易类型为JSAPI必传
     */
    private String openId;

    /**
     * h5支付场景
     */
    private String sceneInfo;

    /**
     * 产品id native支付必传
     */
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId( String productId ) {
        this.productId = productId;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo( String sceneInfo ) {
        this.sceneInfo = sceneInfo;
    }

    public String getTradeLimit() {
        return tradeLimit;
    }

    public void setTradeLimit( String tradeLimit ) {
        this.tradeLimit = tradeLimit;
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

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp( String requestIp ) {
        this.requestIp = requestIp;
    }

    public String getBody() {
        return body;
    }

    public void setBody( String body ) {
        this.body = body;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount( String amount ) {
        this.amount = amount;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime( String beginTime ) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime( String endTime ) {
        this.endTime = endTime;
    }

}
