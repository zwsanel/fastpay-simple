package com.lilipay.wechat.gateway.domain;


public class WechatOrderRepayGateOutput {


    private WechatAppPayOutputRequest appPayRequest;

    public WechatAppPayOutputRequest getAppPayRequest() {
        return appPayRequest;
    }

    public void setAppPayRequest( WechatAppPayOutputRequest appPayRequest ) {
        this.appPayRequest = appPayRequest;
    }
}
