package com.fastpay.wechat.mapper;

import org.apache.ibatis.annotations.Param;

import com.fastpay.wechat.entity.WechatRefundEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WechatRefundEntityMapper {
    int deleteByPrimaryKey( Integer id );

    int insert( WechatRefundEntity record );

    int insertSelective( WechatRefundEntity record );

    WechatRefundEntity selectByPrimaryKey( Integer id );

    int updateByPrimaryKeySelective( WechatRefundEntity record );

    int updateByPrimaryKey( WechatRefundEntity record );

    WechatRefundEntity selectByRequestNo( @Param( "requestNo" ) String requestNo );
}