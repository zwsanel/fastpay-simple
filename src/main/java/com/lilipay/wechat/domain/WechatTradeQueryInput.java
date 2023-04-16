package com.lilipay.wechat.domain;

public class WechatTradeQueryInput {

    /**
     * 商户订单号
     */
    private String memberOrderNo;

    /**
     * 微信支付订单号
     */
    private String wechatOrderNo;

    public String getMemberOrderNo() {
        return memberOrderNo;
    }

    public void setMemberOrderNo( String memberOrderNo ) {
        this.memberOrderNo = memberOrderNo;
    }

    public String getWechatOrderNo() {
        return wechatOrderNo;
    }

    public void setWechatOrderNo( String wechatOrderNo ) {
        this.wechatOrderNo = wechatOrderNo;
    }
}
