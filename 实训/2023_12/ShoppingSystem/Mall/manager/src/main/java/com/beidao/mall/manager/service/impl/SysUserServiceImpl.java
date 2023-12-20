package com.beidao.mall.manager.service.impl;

import com.beidao.mall.manager.mapper.SysUserMapper;
import com.beidao.mall.manager.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;


}
