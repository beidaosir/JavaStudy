package com.hnu.test;

import com.hnu.bean.Admin;
import com.hnu.service.AdminService;
import com.hnu.service.impl.AdminServiceImpl;

public class AdminServiceTest {

    public static void main(String[] args) {

        AdminService adminService = new AdminServiceImpl();
        Admin login = adminService.login(32131321,"123456");
        System.out.println(login);
    }
}
