package com.hnu.mapper;


import com.hnu.po.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {

    int add(Employee employee);

    Employee findById(Integer empno);

    @Select("select empno,ename,job,hiredate,sal from emp")
    List<Employee> findAll();
}
