package com.fastpay.bankpay.channel.gate.message.m200004;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class ResQtdetail200004 {

    /**
     * 交易批次号
     */
    @XmlElement( name = "BATCHID" )
    private String batchId;

    /**
     * 记录序号
     */
    @XmlElement( name = "SN" )
    private String sn;

    /**
     * 交易方向
     */
    @XmlElement( name = "TRXDIR" )
    private String trxDir;

    /**
     * 清算日期
     */
    @XmlElement( name = "SETTDAY" )
    private String settleDay;

    /**
     * 完成时间
     */
    @XmlElement( name = "FINTIME" )
    private String finTime;

    /**
     * 提交时间
     */
    @XmlElement( name = "SUBMITTIME" )
    private String submitTime;

    /**
     * 账号
     */
    @XmlElement( name = "ACCOUNT_NO" )
    private String accountNo;

    /**
     * 金额
     */
    @XmlElement( name = "AMOUNT" )
    private String amount;

    /**
     * 自定义用户号
     */
    @XmlElement( name = "CUST_USERID" )
    private String custUserId;

    /**
     * 备注
     */
    @XmlElement( name = "REMARK" )
    private String remark;

    /**
     * 交易附言
     */
    @XmlElement( name = "SUMMARY" )
    private String summary;

    /**
     * 银行流水
     */
    @XmlElement( name = "VOUCHERNO" )
    private String voucherNo;

    /**
     * 返回码
     */
    @XmlElement( name = "RET_CODE" )
    private String retCode;

    /**
     * 错误文本
     */
    @XmlElement( name = "ERR_MSG" )
    private String errMsg;

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId( String batchId ) {
        this.batchId = batchId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn( String sn ) {
        this.sn = sn;
    }

    public String getTrxDir() {
        return trxDir;
    }

    public void setTrxDir( String trxDir ) {
        this.trxDir = trxDir;
    }

    public String getSettleDay() {
        return settleDay;
    }

    public void setSettleDay( String settleDay ) {
        this.settleDay = settleDay;
    }

    public String getFinTime() {
        return finTime;
    }

    public void setFinTime( String finTime ) {
        this.finTime = finTime;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime( String submitTime ) {
        this.submitTime = submitTime;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo( String accountNo ) {
        this.accountNo = accountNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount( String amount ) {
        this.amount = amount;
    }

    public String getCustUserId() {
        return custUserId;
    }

    public void setCustUserId( String custUserId ) {
        this.custUserId = custUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary( String summary ) {
        this.summary = summary;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo( String voucherNo ) {
        this.voucherNo = voucherNo;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode( String retCode ) {
        this.retCode = retCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg( String errMsg ) {
        this.errMsg = errMsg;
    }
}
