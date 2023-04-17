package com.lilipay.bankpay.impl;

import com.lilipay.bankpay.BankPayService;
import com.lilipay.bankpay.domain.*;
import com.lilipay.bankpay.entity.BankPayInEntity;
import com.lilipay.bankpay.mapper.BankPayInEntityMapper;
import com.lilipay.common.Constants;
import com.lilipay.common.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class BankPayServiceImpl implements BankPayService {

    @Resource
    private BankPayInEntityMapper bankPayInEntityMapper;

    @Override
    public Response<PayInResult> payIn( PayInRequest payInRequest ) {

        BankPayInEntity bankPayInEntity = new BankPayInEntity();
        bankPayInEntity.setRequestNo( payInRequest.getRequestNo() );
        bankPayInEntity.setProcessNo( UUID.randomUUID().toString().replace( "-", "" ) );
        bankPayInEntity.setIdNo( payInRequest.getIdNo() );
        bankPayInEntity.setCardNo( payInRequest.getCardNo() );
        bankPayInEntity.setCardName( payInRequest.getCardName() );
        bankPayInEntity.setCardMobile( payInRequest.getCardMobile() );
        bankPayInEntity.setBankCode( payInRequest.getBankCode() );
        bankPayInEntity.setAmount( payInRequest.getAmount() );
        bankPayInEntity.setStatus( Constants.BANK_PAY_PROCESSING );
        bankPayInEntityMapper.insertSelective( bankPayInEntity );
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
