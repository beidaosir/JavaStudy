package com.hnu.test;

import com.hnu.bean.Business;
import com.hnu.dao.BusinessDao;
import com.hnu.dao.impl.BusinessDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BusinessDaoTest {

    /**
     * 使用单元测试
     */

    @Test
    public void testList(){
        BusinessDao businessDao = new BusinessDaoImpl();
        List<Business> businessList = businessDao.listBusiness("雪", "");
        System.out.println(businessList);

    }

    @Test
    public void testGetById(){
        BusinessDao businessDao = new BusinessDaoImpl();
        Business business = businessDao.getBusinessById(10002);
        System.out.println(business);
    }

    @Test
    public void testSave(){
        BusinessDao businessDao = new BusinessDaoImpl();
        boolean b = businessDao.saveBusiness("胖东来");
        System.out.println(b);
    }

    @Test
    public void testUpdate(){
        BusinessDao businessDao = new BusinessDaoImpl();
        Business business = new Business(10002,null,"肯德基","平原湖","疯狂星期四",20.6,2.8);
        boolean b = businessDao.updateBusiness(business);
        System.out.println(b);
    }

    @Test
    public void testUpdatePwd(){
        BusinessDao businessDao = new BusinessDaoImpl();
        boolean b = businessDao.updateBusinessByPassword(10002,"123456");
        System.out.println(b);

    }

    @Test
    public void testRemove(){
        BusinessDao businessDao = new BusinessDaoImpl();
        boolean b = businessDao.removeBusiness(10003);
        System.out.println(b);
    }

    @Test
    public void testLogin(){
        BusinessDao businessDao = new BusinessDaoImpl();
        Business business = businessDao.login(10001,"111111");
        System.out.println(business);

    }



}
