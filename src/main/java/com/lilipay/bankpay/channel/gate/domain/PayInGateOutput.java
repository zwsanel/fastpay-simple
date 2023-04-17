package com.lilipay.bankpay.channel.gate.domain;

public class PayInGateOutput<T> {

    /**
     * 返回码1
     */
    private String retCode1;

    /**
     * 返回描述1
     */
    private String retMsg1;

    /**
     * 返回码2
     */
    private String retCode2;

    /**
     * 返回描述2
     */
    private String retMsg2;

    /**
     * 返回码3
     */
    private String retCode3;

    /**
     * 返回描述3
     */
    private String retMsg3;

    /**
     * 扩展数据
     */
    private T extData;

    public String getRetCode1() {
        return retCode1;
    }

    public void setRetCode1( String retCode1 ) {
        this.retCode1 = retCode1;
    }

    public String getRetMsg1() {
        return retMsg1;
    }

    public void setRetMsg1( String retMsg1 ) {
        this.retMsg1 = retMsg1;
    }

    public String getRetCode2() {
        return retCode2;
    }

    public void setRetCode2( String retCode2 ) {
        this.retCode2 = retCode2;
    }

    public String getRetMsg2() {
        return retMsg2;
    }

    public void setRetMsg2( String retMsg2 ) {
        this.retMsg2 = retMsg2;
    }

    public String getRetCode3() {
        return retCode3;
    }

    public void setRetCode3( String retCode3 ) {
        this.retCode3 = retCode3;
    }

    public String getRetMsg3() {
        return retMsg3;
    }

    public void setRetMsg3( String retMsg3 ) {
        this.retMsg3 = retMsg3;
    }

    public T getExtData() {
        return extData;
    }

    public void setExtData( T extData ) {
        this.extData = extData;
    }
}
