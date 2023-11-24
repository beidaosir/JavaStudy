package com.hnu.service;

import com.hnu.bean.Admin;

public interface AdminService {


    /*
    管理员登录
     */
    public Admin login(Integer adminId,String password);
}
