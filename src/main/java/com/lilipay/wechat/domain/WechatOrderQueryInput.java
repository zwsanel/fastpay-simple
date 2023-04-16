package com.lilipay.wechat.domain;

public class WechatOrderQueryInput {

    /**
     * 请求流水号
     */
    private String requestNo;

    /**
     * 预支付ID
     */
    private String prepayId;

    /**
     * 是否同步结果
     */
    private Boolean syncResult;

    /**
     * 自动关闭订单
     */
    private Boolean closeOrder;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId( String prepayId ) {
        this.prepayId = prepayId;
    }

    public Boolean getSyncResult() {
        return syncResult;
    }

    public void setSyncResult( Boolean syncResult ) {
        this.syncResult = syncResult;
    }

    public Boolean getCloseOrder() {
        return closeOrder;
    }

    public void setCloseOrder( Boolean closeOrder ) {
        this.closeOrder = closeOrder;
    }
}
