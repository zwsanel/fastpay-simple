package com.fastpay.bankpay.channel.gate.message.m200004;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "AIPG" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ReqAipg200004 {

    @XmlElement( name = "INFO" )
    private ReqInfo200004 info;

    @XmlElement( name = "QTRANSREQ" )
    private ReqQTransreq200004 qtransreq;

    public ReqInfo200004 getInfo() {
        return info;
    }

    public void setInfo( ReqInfo200004 info ) {
        this.info = info;
    }

    public ReqQTransreq200004 getQtransreq() {
        return qtransreq;
    }

    public void setQtransreq( ReqQTransreq200004 qtransreq ) {
        this.qtransreq = qtransreq;
    }
}
