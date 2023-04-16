package com.lilipay.wechat.gateway.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class WeixinPayOrderNoticeXml {

    /**
     * 返回状态码
     */
    @XmlElement(name = "return_code")
    private String returnCode;
    /**
     * 返回信息
     */
    @XmlElement(name = "return_msg")
    private String returnMsg;
    /**
     * 应用ID
     */
    @XmlElement(name = "appid")
    private String appId;
    /**
     * 商户号
     */
    @XmlElement(name = "mch_id")
    private String mchId;
    /**
     * 设备号
     */
    @XmlElement(name = "device_info")
    private String deviceInfo;
    /**
     * 随机字符串
     */
    @XmlElement(name = "nonce_str")
    private String nonceStr;
    /**
     * 签名
     */
    @XmlElement(name = "sign")
    private String sign;
    /**
     * 业务结果
     */
    @XmlElement(name = "result_code")
    private String resultCode;
    /**
     * 错误代码
     */
    @XmlElement(name = "err_code")
    private String errCode;
    /**
     * 错误代码描述
     */
    @XmlElement(name = "err_code_des")
    private String errCodeDes;
    /**
     * 用户标识
     */
    @XmlElement(name = "openid")
    private String openid;
    /**
     * 是否关注公众账号
     */
    @XmlElement(name = "is_subscribe")
    private String isSubscribe;
    /**
     * 交易类型
     */
    @XmlElement(name = "trade_type")
    private String tradeType;
    /**
     * 付款银行
     */
    @XmlElement(name = "bank_type")
    private String bankType;
    /**
     * 总金额
     */
    @XmlElement(name = "total_fee")
    private String totalFee;
    /**
     * 货币种类
     */
    @XmlElement(name = "fee_type")
    private String feeType;
    /**
     * 现金支付金额
     */
    @XmlElement(name = "cash_fee")
    private String cashFee;
    /**
     * 现金支付货币类型
     */
    @XmlElement(name = "cash_fee_type")
    private String cashFeeType;
    /**
     * 代金券金额
     */
    @XmlElement(name = "coupon_fee")
    private String couponFee;
    /**
     * 代金券使用数量
     */
    @XmlElement(name = "coupon_count")
    private String couponCount;
    /**
     * 代金券ID
     */
    @XmlElement(name = "coupon_id_0")
    private String couponId0;
    /**
     * 单个代金券支付金额
     */
    @XmlElement(name = "coupon_fee_0")
    private String couponFee0;
    /**
     * 代金券ID
     */
    @XmlElement(name = "coupon_id_1")
    private String couponId1;
    /**
     * 单个代金券支付金额
     */
    @XmlElement(name = "coupon_fee_1")
    private String couponFee1;
    /**
     * 代金券ID
     */
    @XmlElement(name = "coupon_id_2")
    private String couponId2;
    /**
     * 单个代金券支付金额
     */
    @XmlElement(name = "coupon_fee_2")
    private String couponFee2;
    /**
     * 微信支付订单号
     */
    @XmlElement(name = "transaction_id")
    private String transactionId;
    /**
     * 商户订单号
     */
    @XmlElement(name = "out_trade_no")
    private String outTradeNo;
    /**
     * 商家数据包
     */
    @XmlElement(name = "attach")
    private String attach;
    /**
     * 支付完成时间
     */
    @XmlElement(name = "time_end")
    private String timeEnd;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public String getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(String couponFee) {
        this.couponFee = couponFee;
    }

    public String getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(String couponCount) {
        this.couponCount = couponCount;
    }

    public String getCouponId0() {
        return couponId0;
    }

    public void setCouponId0(String couponId0) {
        this.couponId0 = couponId0;
    }

    public String getCouponFee0() {
        return couponFee0;
    }

    public void setCouponFee0(String couponFee0) {
        this.couponFee0 = couponFee0;
    }

    public String getCouponId1() {
        return couponId1;
    }

    public void setCouponId1(String couponId1) {
        this.couponId1 = couponId1;
    }

    public String getCouponFee1() {
        return couponFee1;
    }

    public void setCouponFee1(String couponFee1) {
        this.couponFee1 = couponFee1;
    }

    public String getCouponId2() {
        return couponId2;
    }

    public void setCouponId2(String couponId2) {
        this.couponId2 = couponId2;
    }

    public String getCouponFee2() {
        return couponFee2;
    }

    public void setCouponFee2(String couponFee2) {
        this.couponFee2 = couponFee2;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
