package com.fastpay.alipay.mapper;

import com.fastpay.alipay.entity.AlipayAppEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AlipayAppEntityMapper {

    int deleteByPrimaryKey( Long id );

    int insert( AlipayAppEntity record );

    int insertSelective( AlipayAppEntity record );

    AlipayAppEntity selectByPrimaryKey( Long id );

    int updateByPrimaryKeySelective( AlipayAppEntity record );

    int updateByPrimaryKey( AlipayAppEntity record );

    AlipayAppEntity selectByRequestNo( @Param( "requestNo" ) String requestNo );
}