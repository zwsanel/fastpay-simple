package com.fastpay.admin.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BankPayInListRequest {

    /**
     * 商户流水号
     */
    private String requestNo;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo( String requestNo ) {
        this.requestNo = requestNo;
    }
}
