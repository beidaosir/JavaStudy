package com.hnu.test;


import com.hnu.po.Employee;
import com.hnu.service.IEmployeeService;
import com.hnu.service.impl.EmployeeService;
import org.junit.Test;

public class EmployeeServiceTest {

    @Test
    public void testFindById(){

        IEmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.findById(7942);
        System.out.println(employee);
    }
}
