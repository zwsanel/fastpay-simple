package com.lilipay.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class WechatStoreInfo {

    /**
     * 门店ID
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    @JSONField( name = "area_code" )
    private String areaCode;

    /**
     * 地址
     */
    private String address;

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode( String areaCode ) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }
}
