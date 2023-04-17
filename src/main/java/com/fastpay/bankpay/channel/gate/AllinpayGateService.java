package com.fastpay.bankpay.channel.gate;

import com.fastpay.bankpay.channel.gate.domain.PayInGateInput;
import com.fastpay.bankpay.channel.gate.domain.PayInGateOutput;
import com.fastpay.bankpay.channel.gate.domain.PayInQueryGateInput;
import com.fastpay.bankpay.channel.gate.domain.PayInQueryGateOutput;
import com.fastpay.common.Response;

public interface AllinpayGateService {

    Response<PayInGateOutput<Void>> payIn( PayInGateInput payInGateInput );

    Response<PayInQueryGateOutput<Void>> payInQuery( PayInQueryGateInput payInQueryGateInput );
}
