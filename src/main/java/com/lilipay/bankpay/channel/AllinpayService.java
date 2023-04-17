package com.lilipay.bankpay.channel;

import com.lilipay.bankpay.domain.*;
import com.lilipay.common.Response;

public interface AllinpayService {

    Response<PayInResult> payIn( PayInRequest payInRequest );

    Response<PayInQueryResult> payInQuery( PayInQueryRequest payInQueryRequest );

    Response<PayOutResult> payOut( PayOutRequest payOutRequest );

    Response<PayOutQueryResult> payOutQuery( PayOutQueryRequest payOutQueryRequest );
}
