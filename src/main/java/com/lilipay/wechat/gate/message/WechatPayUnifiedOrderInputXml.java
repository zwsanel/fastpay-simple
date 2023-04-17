package com.lilipay.wechat.gate.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WechatPayUnifiedOrderInputXml {

    /**
     * 应用ID
     */
    @XmlElement( name = "appid" )
    private String appId;

    /**
     * 商户号
     */
    @XmlElement( name = "mch_id" )
    private String memberNo;

    /**
     * 设备号
     */
    @XmlElement( name = "device_info" )
    private String deviceInfo;

    /**
     * 随机字符串
     */
    @XmlElement( name = "nonce_str" )
    private String nonceStr;

    /**
     * 签名
     */
    @XmlElement( name = "sign" )
    private String sign;

    /**
     * 签名类型
     */
    @XmlElement( name = "sign_type" )
    private String signType;

    /**
     * 商品描述
     */
    @XmlElement( name = "body" )
    private String body;

    /**
     * 商品详情
     */
    @XmlElement( name = "detail" )
    private String detail;

    /**
     * 附加数据
     */
    @XmlElement( name = "attach" )
    private String attach;

    /**
     * 订单号
     */
    @XmlElement( name = "out_trade_no" )
    private String orderNo;

    /**
     * 货币类型
     */
    @XmlElement( name = "fee_type" )
    private String currency;

    /**
     * 扣款金额
     */
    @XmlElement( name = "total_fee" )
    private String amount;

    /**
     * 终端IP
     */
    @XmlElement( name = "spbill_create_ip" )
    private String createIp;

    /**
     * 交易起始时间
     */
    @XmlElement( name = "time_start" )
    private String beginTime;

    /**
     * 交易结束时间
     */
    @XmlElement( name = "time_expire" )
    private String endTime;

    /**
     * 订单优惠标记
     */
    @XmlElement( name = "goods_tag" )
    private String goodsTag;

    /**
     * 通知地址
     */
    @XmlElement( name = "notify_url" )
    private String notifyUrl;

    /**
     * 交易类型
     */
    @XmlElement( name = "trade_type" )
    private String tradeType;

    /**
     * 商品ID trade_type=NATIVE时，此参数必传
     */
    @XmlElement( name = "product_id" )
    private String productId;
    /**
     * 指定支付方式
     */
    @XmlElement( name = "limit_pay" )
    private String limitPay;

    /**
     * 场景信息
     */
    @XmlElement( name = "scene_info" )
    private String sceneInfo;

    /**
     * 用户在商户appid下的唯一标识
     */
    @XmlElement( name = "openid" )
    private String openid;

    /**
     * 电子发票入口开放标识
     */
    @XmlElement( name = "receipt" )
    private String receipt;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid( String openid ) {
        this.openid = openid;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt( String receipt ) {
        this.receipt = receipt;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId( String appId ) {
        this.appId = appId;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo( String memberNo ) {
        this.memberNo = memberNo;
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

    public String getSign() {
        return sign;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType( String signType ) {
        this.signType = signType;
    }

    public String getBody() {
        return body;
    }

    public void setBody( String body ) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail( String detail ) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach( String attach ) {
        this.attach = attach;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency( String currency ) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount( String amount ) {
        this.amount = amount;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp( String createIp ) {
        this.createIp = createIp;
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

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag( String goodsTag ) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl( String notifyUrl ) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType( String tradeType ) {
        this.tradeType = tradeType;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay( String limitPay ) {
        this.limitPay = limitPay;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo( String sceneInfo ) {
        this.sceneInfo = sceneInfo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId( String productId ) {
        this.productId = productId;
    }
}
