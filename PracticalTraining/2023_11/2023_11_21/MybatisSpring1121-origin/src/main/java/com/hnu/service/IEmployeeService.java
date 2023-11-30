package com.hnu.service;


import com.hnu.po.Employee;

public interface IEmployeeService {

    boolean add(Employee employee);

    Employee findById(Integer empno);
}
