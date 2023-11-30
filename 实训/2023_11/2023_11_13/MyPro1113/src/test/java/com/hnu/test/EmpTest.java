package com.hnu.test;

import com.hnu.po.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class EmpTest {

    SqlSession sqlSession;

    @Before
    public void before() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void testAdd() throws IOException {
        Employee employee = new Employee(9000,"张三丰","销售",7698,new Date(),6000.0,0.0,10);
        int insert = sqlSession.insert("EmployeeMapper.add", employee);
        System.out.println("添加"+insert+"条记录");
        sqlSession.commit();
    }

    @Test
    public void testUpdate() throws IOException {
        Employee employee = new Employee(9000,"包拯","侦探",7788,new Date(),9000.0,1200.0,20);
        int update = sqlSession.update("EmployeeMapper.update", employee);
        System.out.println("修改"+update+"条记录");
        sqlSession.commit();
    }

    @Test
    public void testDel() throws IOException {
        int delete = sqlSession.delete("EmployeeMapper.del", 9000);
        System.out.println("删除"+delete+"条记录");
        sqlSession.commit();
    }
}
