package com.beidao.mall.manager.service;


import com.beidao.mall.model.dto.system.LoginDto;
import com.beidao.mall.model.vo.system.LoginVo;

public interface SysUserService {


    //用户登录
    LoginVo login(LoginDto loginDto);
}
