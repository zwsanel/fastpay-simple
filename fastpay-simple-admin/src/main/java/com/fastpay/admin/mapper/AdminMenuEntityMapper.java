package com.fastpay.admin.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.fastpay.admin.entity.AdminMenuEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMenuEntityMapper {
    int deleteByPrimaryKey( Integer id );

    int insert( AdminMenuEntity record );

    int insertSelective( AdminMenuEntity record );

    AdminMenuEntity selectByPrimaryKey( Integer id );

    int updateByPrimaryKeySelective( AdminMenuEntity record );

    int updateByPrimaryKey( AdminMenuEntity record );

    List<AdminMenuEntity> selectAll();
}