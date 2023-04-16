package com.lilipay.wechat;

import com.lilipay.common.Response;
import com.lilipay.wechat.domain.*;

public interface WechatService {

    /**
     * 统一下单
     *
     * @param wechatUnifiedOrderInput 下单请求
     * @return 下单结果
     */
    Response<WechatUnifiedOrderOutput> unifiedOrder( WechatUnifiedOrderInput wechatUnifiedOrderInput );

    /**
     * 订单查询
     *
     * @param wechatOrderQueryInput 查询请求
     * @return 订单结果
     */
    Response<WechatOrderQueryOutput> orderQuery( WechatOrderQueryInput wechatOrderQueryInput );

    /**
     * 订单关闭
     *
     * @param wechatOrderCloseInput 订单关闭请求
     * @return 订单结果
     */
    Response<WechatOrderCloseOutput> orderClose( WechatOrderCloseInput wechatOrderCloseInput );

    /**
     * 预付单查询
     *
     * @param wechatPrepayQueryInput 预付单查询请求
     * @return 预付单信息
     */
    Response<WechatPrepayQueryOutput> prepayQuery( WechatPrepayQueryInput wechatPrepayQueryInput );

    /**
     * 申请退款
     *
     * @param wechatRefundInput 退款请求
     * @return 退款结果
     */
    Response<WechatRefundOutput> refund( WechatRefundInput wechatRefundInput );

    /**
     * 查询退款结果
     *
     * @param wechatRefundQueryInput 退款查询请求
     * @return 退款结果
     */
    Response<WechatRefundOutput> refundQuery( WechatRefundQueryInput wechatRefundQueryInput );

    /**
     * 企业付款
     *
     * @param wechatTransferInput 企业付款请求
     */
    Response<WechatTransferOutput> transfer( WechatTransferInput wechatTransferInput );

    /**
     * 企业付款查询
     *
     * @param wechatTransferQueryInput 企业付款查询请求
     * @return 查询结果
     */
    Response<WechatTransferOutput> transferQuery( WechatTransferQueryInput wechatTransferQueryInput );

    /**
     * 微信交易查询
     *
     * @param wechatTradeQueryInput 微信交易单号或商户订单号
     * @return 查询结果
     */
    Response<WechatTradeQueryOutput> tradeQuery( WechatTradeQueryInput wechatTradeQueryInput );
}
