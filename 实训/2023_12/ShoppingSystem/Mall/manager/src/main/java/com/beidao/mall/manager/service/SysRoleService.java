package com.beidao.mall.manager.service;

import com.beidao.mall.model.dto.system.SysRoleDto;
import com.beidao.mall.model.entity.system.SysRole;
import com.github.pagehelper.PageInfo;

public interface SysRoleService {

    //角色列表方法，分页查询
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit);
}
