package com.lilipay.alipay.service;

import com.lilipay.alipay.service.domain.*;
import com.lilipay.common.Response;

public interface AlipayGatewayService {

    /**
     * APP支付 (创建订单信息)
     *
     * @param appPayRequest APP支付请求
     * @return APP支付请求创建订单结果
     */
    Response<AlipayAppPayGatewayResult> appPay( AlipayAppPayGatewayRequest appPayRequest );

    /**
     * <a href="https://opendocs.alipay.com/apis/api_1/alipay.trade.query">统一收单线下交易查询</a>
     *
     * @param tradeQueryRequest 统一收单线下交易查询请求
     * @return 统一收单线下交易查询结果
     */
    Response<AlipayTradeQueryGatewayResult> tradeQuery( AlipayTradeQueryGatewayRequest tradeQueryRequest );

    /**
     * <a href="https://opendocs.alipay.com/apis/api_1/alipay.trade.close">统一收单交易关闭接口</a>
     *
     * @param tradeCloseRequest 统一收单交易关闭请求
     * @return 统一收单交易关闭结果
     */
    Response<AlipayTradeCloseGatewayResult> tradeClose( AlipayTradeCloseGatewayRequest tradeCloseRequest );
}
