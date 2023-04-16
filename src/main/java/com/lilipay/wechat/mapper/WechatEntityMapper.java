package com.lilipay.wechat.mapper;

import com.lilipay.wechat.entity.WechatEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WechatEntityMapper {
    int deleteByPrimaryKey( Long id );

    int insert( WechatEntity record );

    int insertSelective( WechatEntity record );

    WechatEntity selectByPrimaryKey( Long id );

    int updateByPrimaryKeySelective( WechatEntity record );

    int updateByPrimaryKey( WechatEntity record );

    WechatEntity selectByRequestNo( @Param( "requestNo" ) String requestNo );
}