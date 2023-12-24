package com.beidao.mall.manager.mapper;

import com.beidao.mall.model.dto.system.SysRoleDto;
import com.beidao.mall.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {

    //角色列表方法，分页查询
    List<SysRole> findByPage(SysRoleDto sysRoleDto);

    //2.角色添加方法
    void save(SysRole sysRole);
}
