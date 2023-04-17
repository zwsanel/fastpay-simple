package com.fastpay.bankpay;

import com.fastpay.bankpay.domain.*;
import com.fastpay.common.Response;

public interface BankPayService {

    Response<PayInResult> payIn( PayInRequest payInRequest );

    Response<PayInQueryResult> payInQuery( PayInQueryRequest payInQueryRequest );

    Response<PayOutResult> payOut( PayOutRequest payOutRequest );

    Response<PayOutQueryResult> payOutQuery( PayOutQueryRequest payOutQueryRequest );
}
