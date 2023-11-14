package com.hnu.test;

import com.hnu.po.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestConn {

    @Test
    public void test01() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);


        //通过id查询
        //选择selectOne方法 需要传入一个参数 这个参数是用来定位sql在配置文件中的位置
        //sql写在哪个配置文件中？---映射配置文件   配置文件都在resources中
//        Employee employee = sqlSession.selectOne("EmployeeMapper.getById",7499);
//        System.out.println(employee);


        List<Employee> employeeList = sqlSession.selectList("EmployeeMapper.getAll");
        for (Employee emp:employeeList
             ) {
            System.out.println(emp);
        }
    }
}
