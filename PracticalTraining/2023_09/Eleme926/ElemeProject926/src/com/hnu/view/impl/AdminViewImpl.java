package com.hnu.view.impl;

import com.hnu.bean.Admin;
import com.hnu.service.AdminService;
import com.hnu.service.impl.AdminServiceImpl;
import com.hnu.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {

    AdminService adminService = new AdminServiceImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public Admin login() {

        System.out.println("-----------您正在登录账号中----------------");

        System.out.println("请输入您的账号：");
        int adminId = scanner.nextInt();
        System.out.println("请输入您的密码：");
        String password = scanner.next();

        return adminService.login(adminId, password);

    }

}