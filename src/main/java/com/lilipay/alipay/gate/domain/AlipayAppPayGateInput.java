package com.lilipay.alipay.gate.domain;

public class AlipayAppPayGateInput {

    /**
     * 商户订单号，由商家自定义，需保证商家系统中唯一。仅支持数字、字母、下划线
     */
    private String outTradeNo;

    /**
     * 品标题/交易标题/订单标题
     */
    private String subject;

    /**
     * 订单总金额，单位为人民币（元）
     */
    private String totalAmount;

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

    /**
     * 商品主类型，取值如下： 0：虚拟类商品； 1：实物类商品。
     */
    private String goodsType;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo( String outTradeNo ) {
        this.outTradeNo = outTradeNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject( String subject ) {
        this.subject = subject;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount( String totalAmount ) {
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

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType( String goodsType ) {
        this.goodsType = goodsType;
    }
}
