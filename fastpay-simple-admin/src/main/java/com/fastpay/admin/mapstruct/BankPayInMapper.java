package com.fastpay.admin.mapstruct;

import com.fastpay.admin.domain.BankPayIn;
import com.fastpay.admin.entity.BankPayInEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring" )
public interface BankPayInMapper {

    BankPayIn mapper( BankPayInEntity bankPayInEntity );

    List<BankPayIn> mapper( List<BankPayInEntity> bankPayInEntities );
}
