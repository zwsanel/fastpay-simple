package com.lilipay.wechat.gateway.impl;

import com.lilipay.common.Response;
import com.lilipay.wechat.gateway.WechatGateService;
import com.lilipay.wechat.gateway.domain.*;
import org.springframework.stereotype.Service;

@Service
public class WechatGateServiceImpl implements WechatGateService {

    @Override
    public Response<WechatPayUnifiedOrderGateOutput> unifiedOrder( WechatPayUnifiedOrderGateInput weixinUnifiedOrderRequest ) {
        return null;
    }

    @Override
    public Response<WechatPayOrderQueryGateOutput> orderQuery( WechatPayOrderQueryGateInput weixinOrderQueryRequest ) {
        return null;
    }

    @Override
    public Response<WechatPayNoticeGateOutput> acceptNotice( WechatPayNoticeGateInput weixinPayNoticeRequest ) {
        return null;
    }

    @Override
    public Response<WechatCloseOrderGateOutput> closeOrder( WechatCloseOrderGateInput weixinCloseOrderRequest ) {
        return null;
    }

    @Override
    public Response<WechatPayDownloadBillGateOutput> downloadBill( WechatPayDownloadBillGateInput weixinDownloadBillRequest ) {
        return null;
    }

    @Override
    public Response<WechatPayRefundGateOutput> refund( WechatPayRefundGateInput weixinPayRefundRequest ) {
        return null;
    }

    @Override
    public Response<WechatPayRefundQueryGateOutput> refundQuery( WechatPayRefundQueryGateInput weixinPayRefundQueryRequest ) {
        return null;
    }

    @Override
    public Response<WechatPayRefundNoticeGateOutput> acceptRefundNotice( WechatPayRefundNoticeGateInput weixinPayRefundNoticeRequest ) {
        return null;
    }

    @Override
    public Response<WechatOrderRepayGateOutput> orderRepay( WechatOrderRepayGateInput weixinOrderRepayRequest ) {
        return null;
    }

    @Override
    public Response<WechatTransfersGateOutput> transfers( WechatTransfersGateInput transfersRequest ) {
        return null;
    }

    @Override
    public Response<WechatTransfersQueryGateOutput> transfersQuery( WechatTransfersQueryGateInput transfersQueryRequest ) {
        return null;
    }
}
