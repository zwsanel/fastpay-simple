package com.fastpay.wechat.gate;

import com.fastpay.common.Response;
import com.fastpay.wechat.gate.domain.*;

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
}
