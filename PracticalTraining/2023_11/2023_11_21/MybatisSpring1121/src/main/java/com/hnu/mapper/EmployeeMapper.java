package com.hnu.mapper;


import com.hnu.po.Employee;

public interface EmployeeMapper {

    int add(Employee employee);

    Employee findById(Integer empno);
}
