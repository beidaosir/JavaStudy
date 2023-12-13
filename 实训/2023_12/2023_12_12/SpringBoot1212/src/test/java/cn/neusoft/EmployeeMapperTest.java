package cn.neusoft;

import cn.neusoft.mapper.EmployeeMapper;
import cn.neusoft.po.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloApplication.class})
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void testGetById(){
        Employee employee = employeeMapper.getById(9004);
        System.out.println(employee);
    }
}
