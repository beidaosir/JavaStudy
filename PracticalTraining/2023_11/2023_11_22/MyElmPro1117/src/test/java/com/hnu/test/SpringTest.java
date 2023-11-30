package com.hnu.test;

import com.hnu.mapper.AdminMapper;
import com.hnu.mapper.BusinessMapper;
import com.hnu.mapper.FoodMapper;
import com.hnu.po.Business;
import com.hnu.po.Food;
import com.hnu.service.BusinessService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactory factory;

    @Autowired
    BusinessMapper businessMapper;

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    AdminMapper adminMapper;


    @Test
    public void test01(){
        System.out.println(dataSource.hashCode());
        System.out.println(factory.openSession());
    }


    @Test
    public void test02(){
        //System.out.println(businessMapper);
        Business business = businessMapper.getById(10001);
        System.out.println(business);
        Food food = foodMapper.getById(111);
        System.out.println(food);
    }


    @Autowired
    BusinessService businessService;

    @Test
    public void test03() throws Exception {
        Business business = businessService.getById(10001);
        System.out.println(business);
    }
    @Test
    public void test04() throws Exception {
        boolean del = businessService.del(10016);
        System.out.println(del);
    }


    @Test
    public void test05() throws Exception {
        Business business1 = new Business(null,"978767678","111111","老李面馆1","新乡","好吃",15.0,5.5,"business");
        Business business2 = new Business(null,"536267728","111111","老李面馆2","新乡","好吃",15.0,5.5,"business");
        Business business3 = new Business(null,"473893289","111111","老李面馆3","新乡","好吃",15.0,5.5,"business");
        List<Business> businessList = new ArrayList<>();
        businessList.add(business1);
        businessList.add(business2);
        businessList.add(business3);
        boolean add = businessService.addBatch(businessList);
        System.out.println(add);
    }


}