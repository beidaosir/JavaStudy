package cn.elem.test;

import cn.elem.bean.Admin;
import cn.elem.dao.AdminDao;
import cn.elem.dao.impl.AdminDaoImpl;
import cn.elem.service.AdminService;
import cn.elem.service.impl.AdminServiceImpl;
import org.junit.Test;

public class AdminServiceTest {

    @Test
    public void testLogin(){
        AdminService adminService = new AdminServiceImpl();
        Admin login = adminService.login("zhangsan", "123456");
        System.out.println(login);
    }

}
