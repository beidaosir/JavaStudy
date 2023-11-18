package com.hnu.test;

import com.hnu.po.Business;
import com.hnu.query.BusinessQuery;
import com.hnu.service.BusinessService;
import com.hnu.service.impl.BusinessServiceImpl;
import com.hnu.vo.PageBean;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BusinessServiceTest {

    BusinessService businessService;

    @Before
    public void before(){
        businessService = new BusinessServiceImpl();
    }

    @Test
    public void testAdd(){
        Business business = new Business(null,"32516300","111111","沙县小吃6","新乡","好吃",15.0,4.0,"business");
        boolean add = businessService.add(business);
        System.out.println(add);
    }

    @Test
    public void testGetByPage(){
        BusinessQuery query = new BusinessQuery();
        query.setCurrentPage(2);
        query.setBusinessName("小吃");
        PageBean<Business> pageBean = businessService.getByPage(query);
        System.out.println(pageBean.getTotalRows());
        System.out.println(pageBean.getTotalPages());
        System.out.println(pageBean.getData());
    }

    @Test
    public void testAddBatch(){
        Business business0 = new Business(null,"60003724","111111","沙县小吃12","新乡","好吃",15.0,4.0,"manager");
        Business business1 = new Business(null,"32789131","111111","沙县小吃13","新乡","好吃",15.0,4.0,"manager");
        Business business2 = new Business(null,"32500051","111111","沙县小吃14","新乡","好吃",15.0,4.0,"manager");
        List<Business> businessList = new ArrayList<>();
        businessList.add(business0);
        businessList.add(business1);
        businessList.add(business2);

        boolean add = businessService.addBatch(businessList);
        System.out.println(add);
    }

    @Test
    public void testDelBatch(){
        Integer[] ids = {10019,10020,10021};
        boolean b = businessService.delBatch(ids);
        System.out.println(b);
    }

    @Test
    public void testLogin(){
        Business login = businessService.login("11111111", "111111");
        System.out.println(login);
    }



}