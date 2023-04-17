package com.lilipay.bankpay.channel.gate;

import com.lilipay.bankpay.domain.PayInQueryRequest;
import com.lilipay.bankpay.domain.PayInQueryResult;
import com.lilipay.bankpay.domain.PayInRequest;
import com.lilipay.bankpay.domain.PayInResult;
import com.lilipay.common.Response;

public interface AllinpayGateService {

    Response<PayInResult> payIn( PayInRequest payInRequest );

    Response<PayInQueryResult> payInQuery( PayInQueryRequest payInQueryRequest );
}
