package com.hnu.dao;

import com.hnu.bean.Admin;

public interface AdminDao {


    /*
    管理员登录
     */
    public Admin login(String adminName,String password);
}
