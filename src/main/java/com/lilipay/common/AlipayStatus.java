package com.lilipay.common;

public interface AlipayStatus {

    /**
     * 支付中
     */
    String PAYING = "PAYING";

    /**
     * 失败
     */
    String FAIL = "FAIL";

    /**
     * 成功
     */
    String SUCCESS = "SUCCESS";
}
