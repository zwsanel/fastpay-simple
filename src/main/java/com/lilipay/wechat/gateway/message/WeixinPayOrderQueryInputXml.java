package com.lilipay.wechat.gateway.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeixinPayOrderQueryInputXml extends WeixinPayBasicDomain {

    /**
     * 微信的订单号，优先使用
     */
    @XmlElement(name = "transaction_id")
    private String transactionId;

    /**
     * 商户系统内部的订单号，当没提供transaction_id时需要传这个。
     */
    @XmlElement(name = "out_trade_no")
    private String outTradeNo;

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

}
