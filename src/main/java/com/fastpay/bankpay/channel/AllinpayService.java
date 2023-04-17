package com.fastpay.bankpay.channel;

import com.fastpay.bankpay.domain.*;
import com.fastpay.common.Response;

public interface AllinpayService {

    Response<PayInResult> payIn( PayInRequest payInRequest );

    Response<PayInQueryResult> payInQuery( PayInQueryRequest payInQueryRequest );

    Response<PayOutResult> payOut( PayOutRequest payOutRequest );

    Response<PayOutQueryResult> payOutQuery( PayOutQueryRequest payOutQueryRequest );
}
