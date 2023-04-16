package com.lilipay.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class WechatSceneInfo {

    /**
     * h5支付对应的支付场景信息
     */
    @JSONField( name = "h5_info" )
    private WechatH5Info h5Info;

    /**
     * 支付场景信息 用于线下活动上报门店信息
     */
    @JSONField( name = "store_info" )
    private WechatStoreInfo storeInfo;

    public WechatH5Info getH5Info() {
        return h5Info;
    }

    public void setH5Info( WechatH5Info h5Info ) {
        this.h5Info = h5Info;
    }

    public WechatStoreInfo getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo( WechatStoreInfo storeInfo ) {
        this.storeInfo = storeInfo;
    }
}
