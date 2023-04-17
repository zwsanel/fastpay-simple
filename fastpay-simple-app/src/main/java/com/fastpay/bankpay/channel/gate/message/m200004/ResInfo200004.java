package com.fastpay.bankpay.channel.gate.message.m200004;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class ResInfo200004 {

    /**
     * 交易代码
     */
    @XmlElement( name = "TRX_CODE" )
    private String trxCode;

    /**
     * 版本号
     */
    @XmlElement( name = "VERSION" )
    private String version;

    /**
     * 数据格式
     */
    @XmlElement( name = "DATA_TYPE" )
    private String dataType;

    /**
     * 请求流水号
     */
    @XmlElement( name = "REQ_SN" )
    private String reqSn;

    /**
     * 返回代码
     */
    @XmlElement( name = "RET_CODE" )
    private String retCode;

    /**
     * 错误信息
     */
    @XmlElement( name = "ERR_MSG" )
    private String errMsg;

    /**
     * 签名信息
     */
    @XmlElement( name = "SIGNED_MSG" )
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

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn( String reqSn ) {
        this.reqSn = reqSn;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode( String retCode ) {
        this.retCode = retCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg( String errMsg ) {
        this.errMsg = errMsg;
    }

    public String getSignedMsg() {
        return signedMsg;
    }

    public void setSignedMsg( String signedMsg ) {
        this.signedMsg = signedMsg;
    }
}
