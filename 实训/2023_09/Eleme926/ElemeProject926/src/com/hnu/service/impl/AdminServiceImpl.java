package com.hnu.service.impl;

import com.hnu.bean.Admin;
import com.hnu.data.ElemeDB;
import com.hnu.service.AdminService;

public class AdminServiceImpl implements AdminService {

    //管理员登录  登录成功返回管理员账号

    @Override
    public Admin login(Integer adminId, String password) {

        for (int i = 0; i < ElemeDB.ADMIN_LIST.size(); i++) {
            Admin admin = ElemeDB.ADMIN_LIST.get(i);
            if (admin.getAdminId().equals(adminId) && admin.getPassword().equals(password)){
                return admin;
            }
        }

        return null;
    }
}
