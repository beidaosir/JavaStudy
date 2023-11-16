package com.hnu.test;

import com.hnu.mapper.BusinessMapper;
import com.hnu.po.Business;
import com.hnu.query.BusinessQuery;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BusinessMapperTest {

    @Test
    public void testAdd(){
        SqlSession session = MybatisUtil.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        Business business = new Business(null,"32516356","111111","沙县小吃5","新乡","好吃",15.0,4.0,"manager");
        int add = mapper.add(business);
        session.commit();
        System.out.println(add);
    }

    @Test
    public void testUpdate(){
        SqlSession session = MybatisUtil.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        Business business = new Business(10012,"98765432","111111","心语甜点","新乡","好吃",15.0,4.0,"business");
        int i = mapper.update(business);
        session.commit();
        System.out.println(i);
    }

    @Test
    public void testDel(){
        SqlSession session = MybatisUtil.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        int del = mapper.del(10012);
        session.commit();
        System.out.println(del);
    }


    @Test
    public void testGetById(){
        SqlSession session = MybatisUtil.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        Business business = mapper.getById(10010);
        System.out.println(business);
    }

    @Test
    public void testGetAll(){
        SqlSession session = MybatisUtil.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        List<Business> all = mapper.getAll();
        for (Business business:
                all) {
            System.out.println(business);
        }
    }

    @Test
    public void testGetCount(){
        SqlSession session = MybatisUtil.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        BusinessQuery businessQuery = new BusinessQuery();
        businessQuery.setBusinessName("小吃");
        int count = mapper.getCount(businessQuery);
        System.out.println(count);
    }

    @Test
    public void testGetByPage(){
        SqlSession session = MybatisUtil.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        BusinessQuery businessQuery = new BusinessQuery();
        businessQuery.setBusinessName("小吃");
        businessQuery.setCurrentPage(2);
        List<Business> list = mapper.getByPage(businessQuery);
        for (Business business: list) {
            System.out.println(business);
        }
    }
}
