package com.lilipay.bankpay.channel.impl;

import com.lilipay.bankpay.channel.AllinpayService;
import com.lilipay.bankpay.domain.*;
import com.lilipay.common.Response;
import org.springframework.stereotype.Service;

@Service
public class AllinpayServiceImpl implements AllinpayService {

    @Override
    public Response<PayInResult> payIn( PayInRequest payInRequest ) {
        return null;
    }

    @Override
    public Response<PayInQueryResult> payInQuery( PayInQueryRequest payInQueryRequest ) {
        return null;
    }

    @Override
    public Response<PayOutResult> payOut( PayOutRequest payOutRequest ) {
        return null;
    }

    @Override
    public Response<PayOutQueryResult> payOutQuery( PayOutQueryRequest payOutQueryRequest ) {
        return null;
    }
}
