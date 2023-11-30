package com.hnu.test;

import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;
import com.hnu.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void test01(){



//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        DataSource dataSource = applicationContext.getBean(DataSource.class);
//        System.out.println(dataSource);
//
//        SqlSessionFactory sessionFactory = applicationContext.getBean(SqlSessionFactory.class);
//        SqlSession session = sessionFactory.openSession();
//        System.out.println(session);
/*
        EmployeeMapper employeeMapper = applicationContext.getBean(EmployeeMapper.class);
        System.out.println(employeeMapper);

        Employee employee = employeeMapper.findById(1111);
        System.out.println(employee);*/

        //IEmployeeService service = applicationContext.getBean(IEmployeeService.class);
        //Employee employee = service.findById(1111);
        //System.out.println(dataSource.hashCode());

        Employee employee = employeeMapper.findById(1111);
        System.out.println(employee);

    }

}