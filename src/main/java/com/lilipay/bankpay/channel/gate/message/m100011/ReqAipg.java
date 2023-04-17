package com.lilipay.bankpay.channel.gate.message.m100011;

import javax.xml.bind.annotation.*;

@XmlRootElement( name = "AIPG" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ReqAipg {

    @XmlElement( name = "INFO" )
    private ReqInfo info;

    @XmlElement( name = "TRANS" )
    private ReqTrans trans;

    public ReqInfo getInfo() {
        return info;
    }

    public void setInfo( ReqInfo info ) {
        this.info = info;
    }

    public ReqTrans getTrans() {
        return trans;
    }

    public void setTrans( ReqTrans trans ) {
        this.trans = trans;
    }
}
