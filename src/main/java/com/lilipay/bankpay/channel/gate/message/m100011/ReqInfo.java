package com.lilipay.bankpay.channel.gate.message.m100011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "INFO" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ReqInfo {
    @XmlElement( name = "TRX_CODE" ) //交易代码
    private String trxCode;

    @XmlElement( name = "VERSION" ) //版本号
    private String version;

    @XmlElement( name = "DATA_TYPE" ) //数据格式
    private String dataType;

    @XmlElement( name = "LEVEL" ) //处理级别
    private String level;

    @XmlElement( name = "MERCHANT_ID" ) //商户号
    private String merchantId;

    @XmlElement( name = "USER_NAME" ) //用户名
    private String userName;

    @XmlElement( name = "USER_PASS" ) //用户密码
    private String userPass;

    @XmlElement( name = "REQ_SN" ) //请求流水号
    private String reqSn;

    @XmlElement( name = "SIGNED_MSG" ) //签名信息
    private String signedMsg;

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode( String trxCode ) {
        this.trxCode = trxCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion( String version ) {
        this.version = version;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType( String dataType ) {
        this.dataType = dataType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel( String level ) {
        this.level = level;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId( String merchantId ) {
        this.merchantId = merchantId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass( String userPass ) {
        this.userPass = userPass;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn( String reqSn ) {
        this.reqSn = reqSn;
    }

    public String getSignedMsg() {
        return signedMsg;
    }

    public void setSignedMsg( String signedMsg ) {
        this.signedMsg = signedMsg;
    }
}