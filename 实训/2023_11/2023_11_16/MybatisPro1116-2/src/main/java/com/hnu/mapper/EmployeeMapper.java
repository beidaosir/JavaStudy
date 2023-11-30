package com.hnu.mapper;


import com.hnu.po.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getByDeptno(Integer deptno);

    /*
    用来测试缓存
     */
    Employee getByEmpno(Integer empno);

}