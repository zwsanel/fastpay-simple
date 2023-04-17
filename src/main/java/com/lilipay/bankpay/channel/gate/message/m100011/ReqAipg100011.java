package com.lilipay.bankpay.channel.gate.message.m100011;

import javax.xml.bind.annotation.*;

@XmlRootElement( name = "AIPG" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ReqAipg100011 {

    @XmlElement( name = "INFO" )
    private ReqInfo100011 info;

    @XmlElement( name = "TRANS" )
    private ReqTrans100011 trans;

    public ReqInfo100011 getInfo() {
        return info;
    }

    public void setInfo( ReqInfo100011 info ) {
        this.info = info;
    }

    public ReqTrans100011 getTrans() {
        return trans;
    }

    public void setTrans( ReqTrans100011 trans ) {
        this.trans = trans;
    }
}
