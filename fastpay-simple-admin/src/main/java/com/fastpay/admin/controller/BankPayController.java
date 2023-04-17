package com.fastpay.admin.controller;

import com.fastpay.admin.domain.BankPayIn;
import com.fastpay.admin.domain.BankPayInListRequest;
import com.fastpay.admin.entity.BankPayInEntity;
import com.fastpay.admin.mapper.BankPayInEntityMapper;
import com.fastpay.admin.mapstruct.BankPayInMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping( "admin" )
public class BankPayController {

    @Resource
    private BankPayInMapper bankPayInMapper;

    @Resource
    private BankPayInEntityMapper bankPayInEntityMapper;

    @GetMapping( "bankPayInList" )
    public List<BankPayIn> bankPayInList( BankPayInListRequest bankPayInListRequest ) {
        List<BankPayInEntity> bankPayInEntities = bankPayInEntityMapper.selectByRequestNo( bankPayInListRequest.getRequestNo() );
        return bankPayInMapper.mapper( bankPayInEntities );
    }
}
