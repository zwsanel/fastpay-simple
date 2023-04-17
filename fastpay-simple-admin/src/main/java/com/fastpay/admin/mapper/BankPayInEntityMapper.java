package com.fastpay.admin.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.fastpay.admin.entity.BankPayInEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankPayInEntityMapper {
    int deleteByPrimaryKey( Long id );

    int insert( BankPayInEntity record );

    int insertSelective( BankPayInEntity record );

    BankPayInEntity selectByPrimaryKey( Long id );

    int updateByPrimaryKeySelective( BankPayInEntity record );

    int updateByPrimaryKey( BankPayInEntity record );

    List<BankPayInEntity> selectByRequestNo( @Param( "requestNo" ) String requestNo );
}