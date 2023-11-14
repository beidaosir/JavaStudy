package com.hnu.mapper;


import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {

//    int add(Employee t);
//    int update(Employee t);
//    int del(Integer id);
//    Employee getById(Integer id);
//    List<Employee> getAll();

    List<Employee> getByEname(String enameCondition);

    List<Employee> getByCondition(EmployeeQuery employeeQuery);

    int getCount();

    //传入一个员工编号  得到一个员工姓名
    String getByEmpno(Integer empno);

}
