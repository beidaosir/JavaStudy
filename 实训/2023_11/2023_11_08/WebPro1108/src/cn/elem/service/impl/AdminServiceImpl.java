package cn.elem.service.impl;

import cn.elem.bean.Admin;
import cn.elem.dao.AdminDao;
import cn.elem.dao.impl.AdminDaoImpl;
import cn.elem.service.AdminService;

public class AdminServiceImpl implements AdminService {

    AdminDao adminDao;

    public AdminServiceImpl(){
        adminDao = new AdminDaoImpl();
    }

    /**
     * 登录业务
     * @param adminName
     * @param password
     * @return
     */
    @Override
    public Admin login(String adminName, String password) {

        //根据用户名查询对应的管理员对象
        Admin admin = adminDao.getByName(adminName);
        //判断是否查询对应的管理员信息
        if (admin!=null && admin.getPassword().equals(password)){
           return admin;
        }
        return null;
    }
}
