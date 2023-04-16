package com.lilipay.wechat.gateway.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( value = XmlAccessType.FIELD )
public class WechatPayDownloadBillInputXml extends WechatPayBasicDomain {
    @XmlElement( name = "bill_date" )
    private String billDate;
    @XmlElement( name = "bill_type" )
    private String billType;

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate( String billDate ) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType( String billType ) {
        this.billType = billType;
    }

}
