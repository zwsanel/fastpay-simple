package com.lilipay.alipay.domain;

import com.lilipay.common.BaseDomain;

public class AlipayOrderCloseRequest  {

    /**
     * 请求流水号
     */
    private String requestNo;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }
}
