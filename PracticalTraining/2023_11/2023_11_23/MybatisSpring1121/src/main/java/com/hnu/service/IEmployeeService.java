package com.hnu.service;


import com.hnu.po.Employee;

import java.util.List;

public interface IEmployeeService {

    boolean add(Employee employee);

    Employee findById(Integer empno);
    List<Employee> findAll();
}
