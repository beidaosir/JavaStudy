package com.hnu.mapper;

import com.hnu.po.Employee;

import java.util.List;

public interface EmployeeMapper {

    Employee getById(Integer empno);

    List<Employee> getAll();
}
