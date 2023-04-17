package com.lilipay.bankpay.channel.gate.message.m100011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "AIPG" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ResAipg100011 {

    @XmlElement( name = "INFO" )
    private ResInfo100011 info;

    @XmlElement( name = "TRANSRET" )
    private ResTransret100011 transret;

    public ResInfo100011 getInfo() {
        return info;
    }

    public void setInfo( ResInfo100011 info ) {
        this.info = info;
    }

    public ResTransret100011 getTransret() {
        return transret;
    }

    public void setTransret( ResTransret100011 transret ) {
        this.transret = transret;
    }
}
