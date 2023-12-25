package com.beidao.mall.manager.mapper;


import com.beidao.mall.model.dto.system.SysUserDto;
import com.beidao.mall.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {


    //根据用户名username查询数据库表sys_user表
    SysUser selectUserInfoByUserName(String userName);

    //1、用户条件分页查询接口
    List<SysUser> findByPage(SysUserDto sysUserDto);

    //2、用户添加
    void save(SysUser sysUser);

    //3、用户修改
    void update(SysUser sysUser);

    //4、用户删除
    void delete(Long userId);
}
