package com.lilipay.wechat.gateway;

import com.lilipay.common.Response;
import com.lilipay.wechat.gateway.domain.*;

public interface WechatGateService {

    /**
     * 统一下单
     */
    Response<WechatPayUnifiedOrderGateOutput> unifiedOrder( WechatPayUnifiedOrderGateInput weixinUnifiedOrderRequest );

    /**
     * 查询订单
     */
    Response<WechatPayOrderQueryGateOutput> orderQuery( WechatPayOrderQueryGateInput weixinOrderQueryRequest );

    /**
     * 微信通知请求
     */
    Response<WechatPayNoticeGateOutput> acceptNotice( WechatPayNoticeGateInput weixinPayNoticeRequest );

    /**
     * 微信关闭订单
     */
    Response<WechatCloseOrderGateOutput> closeOrder( WechatCloseOrderGateInput weixinCloseOrderRequest );

    /**
     * 下载对账单
     */
    Response<WechatPayDownloadBillGateOutput> downloadBill( WechatPayDownloadBillGateInput weixinDownloadBillRequest );

    /**
     * 申请退款
     */
    Response<WechatPayRefundGateOutput> refund( WechatPayRefundGateInput weixinPayRefundRequest );

    /**
     * 微信查询退款
     */
    Response<WechatPayRefundQueryGateOutput> refundQuery( WechatPayRefundQueryGateInput weixinPayRefundQueryRequest );

    /**
     * 微信退款通知
     */
    Response<WechatPayRefundNoticeGateOutput> acceptRefundNotice( WechatPayRefundNoticeGateInput weixinPayRefundNoticeRequest );

    /**
     * 预付单查询
     */
    Response<WechatOrderRepayGateOutput> orderRepay( WechatOrderRepayGateInput weixinOrderRepayRequest );

    /**
     * 企业付款
     */
    Response<WechatTransfersGateOutput> transfers( WechatTransfersGateInput transfersRequest );

    /**
     * 查询企业付款
     */
    Response<WechatTransfersQueryGateOutput> transfersQuery( WechatTransfersQueryGateInput transfersQueryRequest );
}
