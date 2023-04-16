package com.lilipay.alipay.domain;

import com.lilipay.common.BaseDomain;

public class AlipayAppPayOrderInfo  {

    /**
     * 唤起支付宝SDK所需的订单信息
     */
    private String orderInfo;

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo( String orderInfo ) {
        this.orderInfo = orderInfo;
    }
}
