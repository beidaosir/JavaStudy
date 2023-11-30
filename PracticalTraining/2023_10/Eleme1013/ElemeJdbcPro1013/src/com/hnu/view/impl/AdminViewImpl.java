package com.hnu.view.impl;

import com.hnu.bean.Admin;

import com.hnu.dao.AdminDao;
import com.hnu.dao.impl.AdminDaoImpl;
import com.hnu.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {

    AdminDao adminDao = new AdminDaoImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public Admin login() {

        System.out.println("-----------您正在登录账号中----------------");

        System.out.println("请输入您的账号：");
        String adminName = scanner.next();
        System.out.println("请输入您的密码：");
        String password = scanner.next();

        return adminDao.login(adminName, password);

    }

}