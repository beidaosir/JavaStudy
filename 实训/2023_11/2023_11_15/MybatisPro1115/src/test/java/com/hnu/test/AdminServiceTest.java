package com.hnu.test;

import com.hnu.po.Admin;
import com.hnu.service.AdminService;
import com.hnu.service.impl.AdminServiceImpl;
import org.junit.Test;

public class AdminServiceTest {

    @Test
    public void testLogin(){
        AdminService adminService = new AdminServiceImpl();
        Admin login = adminService.login("admin", "admin1");
        System.out.println(login);
    }

}