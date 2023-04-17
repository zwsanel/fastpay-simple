package com.fastpay.admin.controller;

import com.fastpay.admin.domain.Menu;
import com.fastpay.admin.mapper.AdminMenuEntityMapper;
import com.fastpay.admin.mapstruct.MenuMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping( "admin" )
public class MenuController {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private AdminMenuEntityMapper adminMenuEntityMapper;

    @GetMapping( "menus" )
    public List<Menu> menus() {
        return menuMapper.mapper( adminMenuEntityMapper.selectAll() );
    }
}
