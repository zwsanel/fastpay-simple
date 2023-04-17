package com.fastpay.bankpay.mapper;

import com.fastpay.bankpay.entity.BankPayInEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankPayInEntityMapper {
    int deleteByPrimaryKey( Long id );

    int insert( BankPayInEntity record );

    int insertSelective( BankPayInEntity record );

    BankPayInEntity selectByPrimaryKey( Long id );

    int updateByPrimaryKeySelective( BankPayInEntity record );

    int updateByPrimaryKey( BankPayInEntity record );
}