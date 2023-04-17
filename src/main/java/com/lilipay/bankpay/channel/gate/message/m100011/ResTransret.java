package com.lilipay.bankpay.channel.gate.message.m100011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class ResTransret {

    // 返回码
    @XmlElement( name = "RET_CODE" )
    private String retCode;

    // 清算日期
    @XmlElement( name = "SETTLE_DAY" )
    private String settleDay;

    // 错误文本
    @XmlElement( name = "ERR_MSG" )
    private String errMsg;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode( String retCode ) {
        this.retCode = retCode;
    }

    public String getSettleDay() {
        return settleDay;
    }

    public void setSettleDay( String settleDay ) {
        this.settleDay = settleDay;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg( String errMsg ) {
        this.errMsg = errMsg;
    }
}
