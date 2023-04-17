package com.lilipay.wechat.gate.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WechatPayRefundResultNoticeXml {

    /**
     * 返回状态码
     */
    private String return_code;

    /**
     * 返回信息
     */
    private String return_msg;

    /**
     * 应用ID
     */
    private String appid;

    /**
     * 退款的商户号
     */
    private String mch_id;

    /**
     * 随机字符串
     */
    private String nonce_str;

    /**
     * 加密信息
     */
    private String req_info;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code( String return_code ) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg( String return_msg ) {
        this.return_msg = return_msg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid( String appid ) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id( String mch_id ) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str( String nonce_str ) {
        this.nonce_str = nonce_str;
    }

    public String getReq_info() {
        return req_info;
    }

    public void setReq_info( String req_info ) {
        this.req_info = req_info;
    }
}
