package com.lilipay.wechat.gate.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "xml" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WechatPayOrderQueryOutputXml extends WechatPayBasicDomain {
    /**
     * SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
     */
    @XmlElement( name = "return_code" )
    private String returnCode;

    /**
     * 返回信息，如非空，为错误原因
     */
    @XmlElement( name = "return_msg" )
    private String returnMsg;

    /**
     * SUCCESS/FAIL
     */
    @XmlElement( name = "result_code" )
    private String resultCode;

    /**
     * 错误代码
     */
    @XmlElement( name = "err_code" )
    private String errCode;

    /**
     * 错误代码描述
     */
    @XmlElement( name = "err_code_des" )
    private String errCodeDes;

    /**
     * 微信支付分配的终端设备号
     */
    @XmlElement( name = "device_info" )
    private String deviceInfo;

    /**
     * 用户在商户appid下的唯一标识
     */
    private String openid;

    /**
     * 调用接口提交的交易类型
     */
    @XmlElement( name = "trade_type" )
    private String tradeType;

    /**
     * 交易状态
     * SUCCESS—支付成功
     * REFUND—转入退款
     * NOTPAY—未支付
     * CLOSED—已关闭
     * REVOKED—已撤销（刷卡支付）
     * USERPAYING--用户支付中
     * PAYERROR--支付失败(其他原因，如银行返回失败)
     */
    @XmlElement( name = "trade_state" )
    private String tradeState;

    /**
     * 付款银行
     */
    @XmlElement( name = "bank_type" )
    private String bankType;

    /**
     * 订单总金额，单位为分
     */
    @XmlElement( name = "total_fee" )
    private String totalFee;

    /**
     * 货币种类 默认人民币：CNY
     */
    @XmlElement( name = "fee_type" )
    private String feeType;

    /**
     * 现金支付金额订单现金支付金额
     */
    @XmlElement( name = "cash_fee" )
    private String cashFee;

    /**
     * 现金支付货币类型
     */
    @XmlElement( name = "cash_fee_type" )
    private String cashFeeType;

    /**
     * 微信支付订单号
     */
    @XmlElement( name = "transaction_id" )
    private String transactionId;

    /**
     * 商户订单号
     */
    @XmlElement( name = "out_trade_no" )
    private String outTradeNo;

    /**
     * 附加数据
     */
    private String attach;

    /**
     * 支付完成时间
     */
    @XmlElement( name = "time_end" )
    private String timeEnd;

    /**
     * 交易状态描述
     */
    @XmlElement( name = "trade_state_desc" )
    private String tradeStateDesc;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode( String returnCode ) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg( String returnMsg ) {
        this.returnMsg = returnMsg;
    }


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode( String resultCode ) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode( String errCode ) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes( String errCodeDes ) {
        this.errCodeDes = errCodeDes;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo( String deviceInfo ) {
        this.deviceInfo = deviceInfo;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid( String openid ) {
        this.openid = openid;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType( String tradeType ) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState( String tradeState ) {
        this.tradeState = tradeState;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType( String bankType ) {
        this.bankType = bankType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee( String totalFee ) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType( String feeType ) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee( String cashFee ) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType( String cashFeeType ) {
        this.cashFeeType = cashFeeType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId( String transactionId ) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo( String outTradeNo ) {
        this.outTradeNo = outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach( String attach ) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd( String timeEnd ) {
        this.timeEnd = timeEnd;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc( String tradeStateDesc ) {
        this.tradeStateDesc = tradeStateDesc;
    }
}
