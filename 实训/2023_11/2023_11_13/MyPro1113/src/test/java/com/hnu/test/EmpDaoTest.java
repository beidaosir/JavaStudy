package com.hnu.test;

import com.hnu.dao.EmployeeDao;
import com.hnu.dao.impl.EmployeeDaoImpl;
import com.hnu.po.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class EmpDaoTest {
    EmployeeDao employeeDao;

    @Before
    public void before(){
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    public void testGetAll(){
        List<Employee> all = employeeDao.getALl();
        for (Employee emp: all) {
            System.out.println(emp);
        }
    }

    @Test
    public void testGetById(){
        Employee employee = employeeDao.getById(7934);
        System.out.println(employee);
    }

    @Test
    public void testAdd(){
        Employee employee = new Employee(9000,"张三丰","销售",7698,new Date(),6000.0,0.0,10);
        int add = employeeDao.add(employee);
        System.out.println(add);
    }

    @Test
    public void testUpdate(){
        Employee employee = new Employee(9000,"包拯","侦探",7788,new Date(),9000.0,1200.0,20);
        int update = employeeDao.update(employee);
        System.out.println(update);
    }

    @Test
    public void testDel(){
        int del = employeeDao.del(9000);
        System.out.println(del);
    }
}
