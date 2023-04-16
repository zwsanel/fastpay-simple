package com.lilipay.wechat.gateway.domain;


public class WechatOrderRepayGateOutput {


    private WechatAppPayOutput appPayRequest;

    public WechatAppPayOutput getAppPayRequest() {
        return appPayRequest;
    }

    public void setAppPayRequest( WechatAppPayOutput appPayRequest ) {
        this.appPayRequest = appPayRequest;
    }
}
