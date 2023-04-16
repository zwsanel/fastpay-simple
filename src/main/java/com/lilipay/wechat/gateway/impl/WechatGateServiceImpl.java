package com.lilipay.wechat.gateway.impl;

import com.lilipay.common.Response;
import com.lilipay.wechat.gateway.WechatGateService;
import com.lilipay.wechat.gateway.domain.*;
import org.springframework.stereotype.Service;

@Service
public class WechatGateServiceImpl implements WechatGateService {

    @Override
    public Response<WechatPayUnifiedOrderGateOutput> unifiedOrder( WechatPayUnifiedOrderGateInput wechatPayUnifiedOrderGateInput ) {
        return null;
    }

    @Override
    public Response<WechatPayOrderQueryGateOutput> orderQuery( WechatPayOrderQueryGateInput wechatPayOrderQueryGateInput ) {
        return null;
    }

    @Override
    public Response<WechatPayNoticeGateOutput> acceptNotice( WechatPayNoticeGateInput wechatPayNoticeGateInput ) {
        return null;
    }

    @Override
    public Response<WechatCloseOrderGateOutput> closeOrder( WechatCloseOrderGateInput wechatCloseOrderGateInput ) {
        return null;
    }

    @Override
    public Response<WechatPayDownloadBillGateOutput> downloadBill( WechatPayDownloadBillGateInput wechatPayDownloadBillGateInput ) {
        return null;
    }

    @Override
    public Response<WechatPayRefundGateOutput> refund( WechatPayRefundGateInput wechatPayRefundGateInput ) {
        return null;
    }

    @Override
    public Response<WechatPayRefundQueryGateOutput> refundQuery( WechatPayRefundQueryGateInput wechatPayRefundQueryGateInput ) {
        return null;
    }

    @Override
    public Response<WechatPayRefundNoticeGateOutput> acceptRefundNotice( WechatPayRefundNoticeGateInput wechatPayRefundNoticeGateInput ) {
        return null;
    }

    @Override
    public Response<WechatOrderRepayGateOutput> orderRepay( WechatOrderRepayGateInput wechatOrderRepayGateInput ) {
        return null;
    }

    @Override
    public Response<WechatTransfersGateOutput> transfers( WechatTransfersGateInput wechatTransfersGateInput ) {
        return null;
    }

    @Override
    public Response<WechatTransfersQueryGateOutput> transfersQuery( WechatTransfersQueryGateInput wechatTransfersQueryGateInput ) {
        return null;
    }
}
