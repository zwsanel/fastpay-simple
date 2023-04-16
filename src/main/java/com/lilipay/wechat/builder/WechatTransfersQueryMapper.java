package com.lilipay.wechat.builder;

import com.lilipay.wechat.gateway.domain.WechatTransfersQueryGateOutput;
import com.lilipay.wechat.gateway.message.WechatTransfersQueryOutput;

public final class WechatTransfersQueryMapper {

    public static WechatTransfersQueryGateOutput mapper( WechatTransfersQueryOutput output ) {
        WechatTransfersQueryGateOutput weixinTransfersQueryResponse = new WechatTransfersQueryGateOutput();
        weixinTransfersQueryResponse.setReturnCode( output.getReturn_code() );
        weixinTransfersQueryResponse.setReturnMsg( output.getReturn_msg() );
        weixinTransfersQueryResponse.setResultCode( output.getResult_code() );
        weixinTransfersQueryResponse.setErrCode( output.getErr_code() );
        weixinTransfersQueryResponse.setErrCodeDes( output.getErr_code_des() );
        weixinTransfersQueryResponse.setPartnerTradeNo( output.getPartner_trade_no() );
        weixinTransfersQueryResponse.setAppid( output.getAppid() );
        weixinTransfersQueryResponse.setMchId( output.getMch_id() );
        weixinTransfersQueryResponse.setDetailId( output.getDetail_id() );
        weixinTransfersQueryResponse.setStatus( output.getStatus() );
        weixinTransfersQueryResponse.setReason( output.getReason() );
        weixinTransfersQueryResponse.setOpenid( output.getOpenid() );
        weixinTransfersQueryResponse.setTransferName( output.getTransfer_name() );
        weixinTransfersQueryResponse.setPaymentAmount( output.getPayment_amount() );
        weixinTransfersQueryResponse.setTransferTime( output.getTransfer_time() );
        weixinTransfersQueryResponse.setPaymentTime( output.getPayment_time() );
        weixinTransfersQueryResponse.setDesc( output.getDesc() );
        return weixinTransfersQueryResponse;
    }
}
