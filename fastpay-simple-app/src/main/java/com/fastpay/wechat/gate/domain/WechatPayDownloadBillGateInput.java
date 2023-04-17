package com.fastpay.wechat.gate.domain;

public class WechatPayDownloadBillGateInput {

    /**
     * 对账日期
     */
    private String billDate;

    /**
     * 对账单类型, 默认下载ALL类型
     */
    private String billType;

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate( String billDate ) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType( String billType ) {
        this.billType = billType;
    }
}
