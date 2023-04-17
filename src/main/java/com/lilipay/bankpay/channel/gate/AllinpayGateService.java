package com.lilipay.bankpay.channel.gate;

import com.lilipay.bankpay.channel.gate.domain.PayInGateInput;
import com.lilipay.bankpay.channel.gate.domain.PayInQueryGateInput;
import com.lilipay.bankpay.channel.gate.domain.PayInQueryGateOutput;
import com.lilipay.bankpay.domain.*;
import com.lilipay.common.Response;

public interface AllinpayGateService {

    Response<PayInQueryGateInput> payIn( PayInGateInput payInGateInput );

    Response<PayInQueryGateOutput> payInQuery( PayInQueryGateInput payInQueryGateInput );
}
