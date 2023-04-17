package com.fastpay.admin.domain;

public class Menu {

    /**
     * 菜单编号
     */
    private String menuNo;

    /**
     * 流水号
     */
    private String title;

    /**
     * 处理号
     */
    private String caption;

    /**
     * 原始订单流水
     */
    private String icon;

    /**
     * 微信商户号
     */
    private String link;

    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo( String menuNo ) {
        this.menuNo = menuNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption( String caption ) {
        this.caption = caption;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon( String icon ) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink( String link ) {
        this.link = link;
    }
}
