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
}
