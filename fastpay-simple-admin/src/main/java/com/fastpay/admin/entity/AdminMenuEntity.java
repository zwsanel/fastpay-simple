package com.fastpay.admin.entity;

import java.util.Date;

/**
 * 菜单管理
 */
public class AdminMenuEntity {
    /**
     * 主键
     */
    private Integer id;

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

    /**
     * 退款状态
     */
    private String status;

    /**
     * 退款入账账户
     */
    private String refundRecvAccout;

    /**
     * 创建时间
     */
    private Date dateCreated;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 修改时间
     */
    private Date dateUpdated;

    /**
     * 修改人
     */
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getRefundRecvAccout() {
        return refundRecvAccout;
    }

    public void setRefundRecvAccout( String refundRecvAccout ) {
        this.refundRecvAccout = refundRecvAccout;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated( Date dateCreated ) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy( String createdBy ) {
        this.createdBy = createdBy;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated( Date dateUpdated ) {
        this.dateUpdated = dateUpdated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy( String updatedBy ) {
        this.updatedBy = updatedBy;
    }
}