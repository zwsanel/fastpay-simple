package com.lilipay.bankpay.channel.gate.message.m100011;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "TRANS" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ReqTrans {

    @XmlElement( name = "BUSINESS_CODE" ) //业务代码
    private String businessCode;

    @XmlElement( name = "MERCHANT_ID" ) //商户代码
    private String merchantId;

    @XmlElement( name = "SUBMIT_TIME" ) //提交时间
    private String submitTime;

    @XmlElement( name = "E_USER_CODE" ) //用户编号
    private String userCode;

    @XmlElement( name = "VALIDATE" ) //有效期
    private String validate;

    @XmlElement( name = "CVV2" ) //信用卡CVV2
    private String cvv2;

    @XmlElement( name = "ACCOUNT_TYPE" ) //账号类型
    private String accountType;

    @XmlElement( name = "BANK_CODE" ) //银行代码
    private String bankCode;

    @XmlElement( name = "ACCOUNT_NO" ) //账号
    private String accountNo;

    @XmlElement( name = "ACCOUNT_NAME" ) //账号名
    private String accountName;

    @XmlElement( name = "PROVINCE" ) //开户行所在省
    private String province;

    @XmlElement( name = "CITY" ) //开户行所在市
    private String city;

    @XmlElement( name = "ACCOUNT_PROP" ) //账号属性
    private String accountProp;

    @XmlElement( name = "AMOUNT" ) //金额
    private String amount;

    @XmlElement( name = "CURRENCY" ) //货币类型
    private String currency;

    @XmlElement( name = "ID_TYPE" ) //开户证件类型
    private String idType;

    @XmlElement( name = "ID" ) //证件号
    private String id;

    @XmlElement( name = "TEL" ) //手机号/小灵通
    private String tel;

    @XmlElement( name = "CUST_USERID" ) //自定义用户号
    private String custUserId;

    @XmlElement( name = "SETTACCT" ) //本交易结算户
    private String settacct;

    @XmlElement( name = "REMARK" ) //备注
    private String remark;

    @XmlElement( name = "SETTGROUPFLAG" ) //分组清算标志
    private String settgroupflag;

    @XmlElement( name = "SUMMARY" ) //交易附言
    private String summary;

    @XmlElement( name = "NOTIFYURL" ) //通知地址
    private String notifyUrl;

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode( String businessCode ) {
        this.businessCode = businessCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId( String merchantId ) {
        this.merchantId = merchantId;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime( String submitTime ) {
        this.submitTime = submitTime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode( String userCode ) {
        this.userCode = userCode;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate( String validate ) {
        this.validate = validate;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2( String cvv2 ) {
        this.cvv2 = cvv2;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType( String accountType ) {
        this.accountType = accountType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode( String bankCode ) {
        this.bankCode = bankCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo( String accountNo ) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName( String accountName ) {
        this.accountName = accountName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince( String province ) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getAccountProp() {
        return accountProp;
    }

    public void setAccountProp( String accountProp ) {
        this.accountProp = accountProp;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount( String amount ) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency( String currency ) {
        this.currency = currency;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType( String idType ) {
        this.idType = idType;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel( String tel ) {
        this.tel = tel;
    }

    public String getCustUserId() {
        return custUserId;
    }

    public void setCustUserId( String custUserId ) {
        this.custUserId = custUserId;
    }

    public String getSettacct() {
        return settacct;
    }

    public void setSettacct( String settacct ) {
        this.settacct = settacct;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }

    public String getSettgroupflag() {
        return settgroupflag;
    }

    public void setSettgroupflag( String settgroupflag ) {
        this.settgroupflag = settgroupflag;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary( String summary ) {
        this.summary = summary;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl( String notifyUrl ) {
        this.notifyUrl = notifyUrl;
    }
}

