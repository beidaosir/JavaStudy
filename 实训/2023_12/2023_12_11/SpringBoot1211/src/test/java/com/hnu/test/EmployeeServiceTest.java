package com.hnu.test;

import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import com.hnu.service.IEmployeeService;
import com.hnu.vo.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    IEmployeeService employeeService;

    @Test
    public void testGetByPage(){
        EmployeeQuery query = new EmployeeQuery();
        query.setPageNow(1);
        query.setPageSize(5);
        query.setEname("A");
        PageBean<Employee> pageBean = employeeService.getByPage(query);

        System.out.println(pageBean.getTotalRows());
        System.out.println(pageBean.getTotalPages());
        System.out.println(pageBean.getData());

    }


    @Test
    public void testAdd(){
        Employee employee = new Employee(null,"李四","财务",5000.0);
        int add = employeeService.add(employee);
        System.out.println("添加了："+add+"条记录");
        System.out.println("获取的自增主键："+employee.getEmpno());
    }

    @Test
    public void testAddBatch(){
        Employee employee1 = new Employee(null,"李雷","财务",5000.0);
        Employee employee2 = new Employee(null,"韩梅梅","财务",5000.0);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        boolean isOk = employeeService.addBatch(employeeList);
        System.out.println("批量添加："+isOk);
    }

}
