package com.fastpay.wechat.gate.domain;


public class WechatOrderRepayGateOutput {


    private WechatAppPayOutput appPayRequest;

    public WechatAppPayOutput getAppPayRequest() {
        return appPayRequest;
    }

    public void setAppPayRequest( WechatAppPayOutput appPayRequest ) {
        this.appPayRequest = appPayRequest;
    }
}
