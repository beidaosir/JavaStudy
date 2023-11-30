package com.hnu.test;

import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmployeeMapperTest {

    @Test
    public void testGetById(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getById(7934);
        System.out.println(employee);

    }


    @Test
    public void testGetAll(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> all = mapper.getAll();
        for (Employee e :
                all) {
            System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getDept());
        }

    }

}
