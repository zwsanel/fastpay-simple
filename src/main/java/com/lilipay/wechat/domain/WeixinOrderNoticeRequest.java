package com.lilipay.wechat.domain;

public class WeixinOrderNoticeRequest  {

    /**
     * 微信流水号
     */
    private String memberNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 原始XML报文
     */
    private String noticeXml;

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo( String memberNo ) {
        this.memberNo = memberNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public String getNoticeXml() {
        return noticeXml;
    }

    public void setNoticeXml( String noticeXml ) {
        this.noticeXml = noticeXml;
    }
}
