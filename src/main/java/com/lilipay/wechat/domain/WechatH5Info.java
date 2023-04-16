package com.lilipay.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class WechatH5Info {

    /**
     * 场景类型 IOS|Android|Wap
     */
    private String type;

    /**
     * 应用名
     */
    @JSONField( name = "app_name" )
    private String appName;

    /**
     * bundle_id
     */
    @JSONField( name = "bundle_id" )
    private String budleId;

    /**
     * 包名
     */
    @JSONField( name = "package_name" )
    private String packageName;

    /**
     * WAP网站URL地址
     */
    @JSONField( name = "wap_url" )
    private String wapUrl;

    /**
     * WAP 网站名
     */
    @JSONField( name = "wap_name" )
    private String wapName;

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName( String appName ) {
        this.appName = appName;
    }

    public String getBudleId() {
        return budleId;
    }

    public void setBudleId( String budleId ) {
        this.budleId = budleId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName( String packageName ) {
        this.packageName = packageName;
    }

    public String getWapUrl() {
        return wapUrl;
    }

    public void setWapUrl( String wapUrl ) {
        this.wapUrl = wapUrl;
    }

    public String getWapName() {
        return wapName;
    }

    public void setWapName( String wapName ) {
        this.wapName = wapName;
    }
}
