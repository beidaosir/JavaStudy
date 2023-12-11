package com.hnu.service;

import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import com.hnu.vo.PageBean;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAll();

    PageBean<Employee> getByPage(EmployeeQuery query);

    int add(Employee employee);

    boolean addBatch(List<Employee> employeeList);


}
