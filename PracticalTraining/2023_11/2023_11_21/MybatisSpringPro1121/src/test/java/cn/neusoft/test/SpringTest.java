package cn.neusoft.test;

import cn.neusoft.po.Employee;
import cn.neusoft.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    IEmployeeService employeeService;

    @Test
    public void test01(){
        Employee employee = employeeService.findById(9003);
        System.out.println(employee);
    }

}
