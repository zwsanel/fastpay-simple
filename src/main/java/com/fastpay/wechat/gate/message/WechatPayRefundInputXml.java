package com.fastpay.wechat.gate.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WechatPayRefundInputXml {


    /**
     * 公众账号ID
     */
    private String appid;

    /**
     * 商户号
     */
    private String mch_id;

    /**
     * 随机字符串
     */
    private String nonce_str;

    /**
     * 签名
     */
    private String sign;

    /**
     * 签名类型
     */
    private String sign_type;

    /**
     * 微信订单号
     */
    private String transaction_id;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 商户退款单号
     */
    private String out_refund_no;

    /**
     * 订单金额
     */
    private Integer total_fee;

    /**
     * 退款金额
     */
    private Integer refund_fee;

    /**
     * 退款货币种类
     */
    private String refund_fee_type;

    /**
     * 退款原因
     */
    private String refund_desc;

    /**
     * 退款资金来源
     */
    private String refund_account;

    /**
     * 退款结果通知url
     */
    private String notify_url;

    public String getAppid() {
        return appid;
    }

    public void setAppid( String appid ) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id( String mch_id ) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str( String nonce_str ) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type( String sign_type ) {
        this.sign_type = sign_type;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id( String transaction_id ) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no( String out_trade_no ) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no( String out_refund_no ) {
        this.out_refund_no = out_refund_no;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee( Integer total_fee ) {
        this.total_fee = total_fee;
    }

    public Integer getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee( Integer refund_fee ) {
        this.refund_fee = refund_fee;
    }

    public String getRefund_fee_type() {
        return refund_fee_type;
    }

    public void setRefund_fee_type( String refund_fee_type ) {
        this.refund_fee_type = refund_fee_type;
    }

    public String getRefund_desc() {
        return refund_desc;
    }

    public void setRefund_desc( String refund_desc ) {
        this.refund_desc = refund_desc;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public void setRefund_account( String refund_account ) {
        this.refund_account = refund_account;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url( String notify_url ) {
        this.notify_url = notify_url;
    }
}
