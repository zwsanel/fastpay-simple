package com.fastpay.bankpay.channel.gate.message.m200004;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "TRANS" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ReqQTransreq200004 {

    @XmlElement( name = "MERCHANT_ID" ) //商户代码
    private String merchantId;

    @XmlElement( name = "QUERY_SN" ) //要查询的交易流水
    private String querySn;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId( String merchantId ) {
        this.merchantId = merchantId;
    }

    public String getQuerySn() {
        return querySn;
    }

    public void setQuerySn( String querySn ) {
        this.querySn = querySn;
    }
}

