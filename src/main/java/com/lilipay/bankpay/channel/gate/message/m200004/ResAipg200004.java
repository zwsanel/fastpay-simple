package com.lilipay.bankpay.channel.gate.message.m200004;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement( name = "AIPG" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ResAipg200004 {

    @XmlElement( name = "INFO" )
    private ResInfo200004 info;

    @XmlElementWrapper( name = "QTRANSRSP" )
    @XmlElement( name = "TRANSRET" )
    private List<ResQtdetail200004> qtdetail;

    public ResInfo200004 getInfo() {
        return info;
    }

    public void setInfo( ResInfo200004 info ) {
        this.info = info;
    }

    public List<ResQtdetail200004> getQtdetail() {
        return qtdetail;
    }

    public void setQtdetail( List<ResQtdetail200004> qtdetail ) {
        this.qtdetail = qtdetail;
    }
}
