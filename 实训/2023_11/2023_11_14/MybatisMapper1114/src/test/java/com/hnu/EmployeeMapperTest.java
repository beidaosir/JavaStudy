package com.hnu;


import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmployeeMapperTest {

    @Test
    public void testGetAll(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.getAll();
        for (Employee employee:list) {
            System.out.println(employee);
        }
    }

    @Test
    public void testDel(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int del = mapper.del(9999);
        session.commit();
        System.out.println(del);
    }

    @Test
    public void testGetByName(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.getByEname("李");
        for (Employee employee:list) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetByCondition(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        EmployeeQuery query = new EmployeeQuery("A",30,1000.0,2000.0);
        List<Employee> list = mapper.getByCondition(query);
        for (Employee employee:list) {
            System.out.println(employee);
        }
    }


    @Test
    public void testGetCount(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int count = mapper.getCount();
        System.out.println("总记录数："+count);
    }

    @Test
    public void testGetByEmpno(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        String ename = mapper.getByEmpno(1111);
        System.out.println("姓名为："+ename);
    }

}
