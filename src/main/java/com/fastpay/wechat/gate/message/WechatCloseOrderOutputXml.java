package com.fastpay.wechat.gate.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( value = XmlAccessType.FIELD )
public class WechatCloseOrderOutputXml {

    /**
     * 返回状态码
     */
    @XmlElement( name = "return_code" )
    private String returnCode;

    /**
     * 返回信息
     */
    @XmlElement( name = "return_msg" )
    private String returnMsg;

    /**
     * 应用ID
     */
    @XmlElement( name = "appid" )
    private String appid;

    /**
     * 商户号
     */
    @XmlElement( name = "mch_id" )
    private String mchId;

    /**
     * 随机字符串
     */
    @XmlElement( name = "nonce_str" )
    private String nonceStr;

    /**
     * 签名
     */
    @XmlElement( name = "sign" )
    private String sign;

    /**
     * 返回码
     */
    @XmlElement( name = "result_code" )
    private String resultCode;

    /**
     * 错误代码
     */
    @XmlElement( name = "err_code" )
    private String errCode;

    /**
     * 错误代码描述
     */
    @XmlElement( name = "err_code_des" )
    private String errCodeDes;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode( String returnCode ) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg( String returnMsg ) {
        this.returnMsg = returnMsg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid( String appid ) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId( String mchId ) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr( String nonceStr ) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode( String resultCode ) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode( String errCode ) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes( String errCodeDes ) {
        this.errCodeDes = errCodeDes;
    }
}
