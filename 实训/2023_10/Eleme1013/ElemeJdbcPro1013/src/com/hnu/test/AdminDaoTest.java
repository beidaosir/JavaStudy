package com.hnu.test;

import com.hnu.bean.Admin;
import com.hnu.dao.AdminDao;
import com.hnu.dao.impl.AdminDaoImpl;

public class AdminDaoTest {
    public static void main(String[] args) {

        AdminDao adminDao = new AdminDaoImpl();

        Admin admin = adminDao.login("zhangsan","123456");
        System.out.println(admin);
    }
}
