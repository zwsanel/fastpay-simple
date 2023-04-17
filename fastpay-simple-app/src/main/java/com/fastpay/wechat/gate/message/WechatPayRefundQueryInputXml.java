package com.fastpay.wechat.gate.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WechatPayRefundQueryInputXml {

    /**
     * 应用ID
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
     * 微信退款单号
     */
    private String refund_id;

    /**
     * 偏移量
     */
    private Integer offset;

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

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id( String refund_id ) {
        this.refund_id = refund_id;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset( Integer offset ) {
        this.offset = offset;
    }
}
