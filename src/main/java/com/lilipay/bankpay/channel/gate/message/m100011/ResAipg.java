package com.lilipay.bankpay.channel.gate.message.m100011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "AIPG" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ResAipg {

    @XmlElement( name = "INFO" )
    private ResInfo info;

    @XmlElement( name = "TRANSRET" )
    private ResTransret transret;

    public ResInfo getInfo() {
        return info;
    }

    public void setInfo( ResInfo info ) {
        this.info = info;
    }

    public ResTransret getTransret() {
        return transret;
    }

    public void setTransret( ResTransret transret ) {
        this.transret = transret;
    }
}
