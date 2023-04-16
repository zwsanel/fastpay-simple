package com.lilipay.wechat.gateway.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "root" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WechatPayRefundResultReqInfoXml {

    /**
     * 微信订单号
     */
    private String transaction_id;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 微信退款单号
     */
    private String refund_id;

    /**
     * 商户退款单号
     */
    private String out_refund_no;

    /**
     * 订单金额
     */
    private Integer total_fee;

    /**
     * 应结订单金额
     */
    private Integer settlement_total_fee;

    /**
     * 申请退款金额
     */
    private Integer refund_fee;

    /**
     * 退款金额
     */
    private Integer settlement_refund_fee;

    /**
     * 退款状态
     */
    private String refund_status;

    /**
     * 退款成功时间
     */
    private String success_time;

    /**
     * 退款入账账户
     */
    private String refund_recv_accout;

    /**
     * 退款资金来源
     */
    private String refund_account;

    /**
     * 退款发起来源
     */
    private String refund_request_source;

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

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id( String refund_id ) {
        this.refund_id = refund_id;
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

    public Integer getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public void setSettlement_total_fee( Integer settlement_total_fee ) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public Integer getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee( Integer refund_fee ) {
        this.refund_fee = refund_fee;
    }

    public Integer getSettlement_refund_fee() {
        return settlement_refund_fee;
    }

    public void setSettlement_refund_fee( Integer settlement_refund_fee ) {
        this.settlement_refund_fee = settlement_refund_fee;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public void setRefund_status( String refund_status ) {
        this.refund_status = refund_status;
    }

    public String getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time( String success_time ) {
        this.success_time = success_time;
    }

    public String getRefund_recv_accout() {
        return refund_recv_accout;
    }

    public void setRefund_recv_accout( String refund_recv_accout ) {
        this.refund_recv_accout = refund_recv_accout;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public void setRefund_account( String refund_account ) {
        this.refund_account = refund_account;
    }

    public String getRefund_request_source() {
        return refund_request_source;
    }

    public void setRefund_request_source( String refund_request_source ) {
        this.refund_request_source = refund_request_source;
    }
}
