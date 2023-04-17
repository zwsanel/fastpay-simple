package com.fastpay.alipay;

import com.fastpay.alipay.domain.*;
import com.fastpay.common.Response;

/**
 * 支付宝服务
 */
public interface AlipayService {

    /**
     * APP支付
     *
     * @param alipayAppPayRequest APP支付请求
     * @return APP支付订单信息 前端使用订单信息唤起支付宝SDK
     */
    Response<AlipayAppPayOrderInfo> appPay( AlipayAppPayInput alipayAppPayRequest );

    /**
     * 订单查询
     *
     * @param orderQueryRequest 订单查询请求
     * @return 订单信息
     */
    Response<AlipayAppPayTradeOutput> tradeQuery( AlipayTradeQueryInput orderQueryRequest );

    /**
     * 订单同步
     *
     * @return 订单信息
     */
    Response<AlipayAppPayTradeOutput> tradeSync( AlipayTradeSyncInput tradeSyncRequest );

    /**
     * 尝试关闭订单 <br/>
     * 用户未支付订单关闭成功会返回交易失败，如果用户已支付会返回交易成功
     *
     * @param orderCloseRequest 订单关闭请求
     * @return 订单信息
     */
    Response<AlipayAppPayTradeOutput> orderClose( AlipayOrderCloseInput orderCloseRequest );
}
