package cn.elem.test;

import cn.elem.bean.Business;
import cn.elem.service.BusinessService;
import cn.elem.service.impl.BusinessServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class BusinessServiceTest {

    BusinessService businessService;

    @Before
    public void before(){
        businessService = new BusinessServiceImpl();
    }

    @Test
    public void testAdd(){
        //测试添加
        Business business = new Business(null,"00000000","111111","王婆大虾","新乡","好吃",15.0,4.0,"business");
        boolean add = businessService.add(business);
        System.out.println(add);
    }

    @Test
    public void testUpdate(){
        //测试添加
        Business business = new Business(10010,"00000000","111111","王婆大侠","经七路","好多虾哦",55.0,9.9,"business");
        boolean update = businessService.update(business);
        System.out.println(update);
    }



}
