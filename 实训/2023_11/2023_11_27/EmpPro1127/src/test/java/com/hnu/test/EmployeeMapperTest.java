package com.hnu.test;

import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void testGetCount(){
        EmployeeQuery query = new EmployeeQuery();
        query.setEname("A");
        int count = employeeMapper.getCount(query);
        System.out.println(count);
    }

    @Test
    public void testGetByPage(){
        EmployeeQuery query = new EmployeeQuery();
        query.setCurrentPage(2);
        query.setEname("A");
        List<Employee> employeeList = employeeMapper.getByPage(query);
        for (Employee employee:employeeList) {
            System.out.println(employee);
        }
    }

}
