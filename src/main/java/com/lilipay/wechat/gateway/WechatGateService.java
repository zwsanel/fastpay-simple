package com.lilipay.wechat.gateway;

import com.lilipay.common.Response;
import com.lilipay.wechat.gateway.domain.*;

public interface WechatGateService {

    /**
     * 统一下单
     */
    Response<WechatPayUnifiedOrderGateOutput> unifiedOrder( WechatPayUnifiedOrderGateInput wechatPayUnifiedOrderGateInput );

    /**
     * 查询订单
     */
    Response<WechatPayOrderQueryGateOutput> orderQuery( WechatPayOrderQueryGateInput wechatPayOrderQueryGateInput );

    /**
     * 微信通知请求
     */
    Response<WechatPayNoticeGateOutput> acceptNotice( WechatPayNoticeGateInput wechatPayNoticeGateInput );

    /**
     * 微信关闭订单
     */
    Response<WechatCloseOrderGateOutput> closeOrder( WechatCloseOrderGateInput wechatCloseOrderGateInput );

    /**
     * 申请退款
     */
    Response<WechatPayRefundGateOutput> refund( WechatPayRefundGateInput wechatPayRefundGateInput );

    /**
     * 微信查询退款
     */
    Response<WechatPayRefundQueryGateOutput> refundQuery( WechatPayRefundQueryGateInput wechatPayRefundQueryGateInput );

    /**
     * 微信退款通知
     */
    Response<WechatPayRefundNoticeGateOutput> acceptRefundNotice( WechatPayRefundNoticeGateInput wechatPayRefundNoticeGateInput );

    /**
     * 预付单查询
     */
    Response<WechatOrderRepayGateOutput> orderRepay( WechatOrderRepayGateInput wechatOrderRepayGateInput );

    /**
     * 企业付款
     */
    Response<WechatTransfersGateOutput> transfers( WechatTransfersGateInput wechatTransfersGateInput );

    /**
     * 查询企业付款
     */
    Response<WechatTransfersQueryGateOutput> transfersQuery( WechatTransfersQueryGateInput wechatTransfersQueryGateInput );
}
