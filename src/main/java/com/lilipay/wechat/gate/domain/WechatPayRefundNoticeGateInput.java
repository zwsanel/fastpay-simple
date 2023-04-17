package com.lilipay.wechat.gate.domain;

public class WechatPayRefundNoticeGateInput {

    private String apiKey;

    private String noticeXml;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey( String apiKey ) {
        this.apiKey = apiKey;
    }

    public String getNoticeXml() {
        return noticeXml;
    }

    public void setNoticeXml( String noticeXml ) {
        this.noticeXml = noticeXml;
    }
}
