package com.fastpay.wechat.builder;

import com.fastpay.wechat.gate.domain.WechatTransfersGateOutput;
import com.fastpay.wechat.gate.message.WechatTransfersOutput;

public final class WechatTransfersResponseMapper {

    public static WechatTransfersGateOutput mapper( WechatTransfersOutput output ) {
        WechatTransfersGateOutput weixinTransfersResponse = new WechatTransfersGateOutput();
        weixinTransfersResponse.setReturnCode( output.getReturn_code() );
        weixinTransfersResponse.setReturnMsg( output.getReturn_msg() );
        weixinTransfersResponse.setMchAppid( output.getMch_appid() );
        weixinTransfersResponse.setMchid( output.getMchid() );
        weixinTransfersResponse.setDeviceInfo( output.getDevice_info() );
        weixinTransfersResponse.setNonceStr( output.getNonce_str() );
        weixinTransfersResponse.setResultCode( output.getResult_code() );
        weixinTransfersResponse.setErrCode( output.getErr_code() );
        weixinTransfersResponse.setErrCodeDes( output.getErr_code_des() );
        weixinTransfersResponse.setPartnerTradeNo( output.getPartner_trade_no() );
        weixinTransfersResponse.setPaymentNo( output.getPayment_no() );
        weixinTransfersResponse.setPaymentTime( output.getPayment_time() );
        return weixinTransfersResponse;
    }
}
