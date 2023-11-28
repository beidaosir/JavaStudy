package com.hnu.test;


import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import com.hnu.service.IEmployeeService;
import com.hnu.vo.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {

    @Autowired
    IEmployeeService employeeService;

    @Test
    public void testFindByPage(){

        EmployeeQuery employeeQuery = new EmployeeQuery();
        employeeQuery.setEname("A");
        PageBean<Employee> pageBean = employeeService.findByPage(employeeQuery);
        System.out.println(pageBean.getTotalRows());
        System.out.println(pageBean.getTotalPages());
        List<Employee> data = pageBean.getData();
        for (Employee employee:data) {
            System.out.println(employee);
        }
    }

}
