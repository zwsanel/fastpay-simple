package com.lilipay.bankpay;

import com.lilipay.bankpay.domain.*;
import com.lilipay.common.Response;

public interface BankPayService {

    Response<PayInResult> payIn( PayInRequest payInRequest );

    Response<PayInQueryResult> payInQuery( PayInQueryRequest payInQueryRequest );

    Response<PayOutResult> payOut( PayOutRequest payOutRequest );

    Response<PayOutQueryResult> payOutQuery( PayOutQueryRequest payOutQueryRequest );
}
