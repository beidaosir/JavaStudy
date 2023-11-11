package cn.elem.test;

import cn.elem.bean.Admin;
import cn.elem.dao.AdminDao;
import cn.elem.dao.impl.AdminDaoImpl;
import org.junit.Test;

public class AdminDaoTest {

    @Test
    public void testFindByName(){
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.getByName("admin111");
        System.out.println(admin);
    }

}
