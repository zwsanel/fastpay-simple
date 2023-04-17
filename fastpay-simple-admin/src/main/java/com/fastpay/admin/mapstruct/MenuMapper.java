package com.fastpay.admin.mapstruct;

import com.fastpay.admin.domain.Menu;
import com.fastpay.admin.entity.AdminMenuEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring" )
public interface MenuMapper {

    Menu mapper( AdminMenuEntity menuEntity );

    List<Menu> mapper( List<AdminMenuEntity> menuEntities );
}
