package com.lilipay.alipay.domain;

import java.math.BigDecimal;

public class AlipayAppPayInput {

    /**
     * 请求流水号
     */
    private String requestNo;

    /**
     * 商品标题/交易标题/订单标题
     */
    private String subject;

    /**
     * 订单总金额，单位为人民币（元）
     */
    private BigDecimal totalAmount;

    /**
     * 该笔订单允许的最晚付款时间，逾期将关闭交易
     */
    private String timeoutExpress;

    /**
     * 绝对超时时间，格式为yyyy-MM-dd HH:mm
     */
    private String timeExpire;

    /**
     * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body
     */
    private String body;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject( String subject ) {
        this.subject = subject;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount( BigDecimal totalAmount ) {
        this.totalAmount = totalAmount;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress( String timeoutExpress ) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire( String timeExpire ) {
        this.timeExpire = timeExpire;
    }

    public String getBody() {
        return body;
    }

    public void setBody( String body ) {
        this.body = body;
    }
}
