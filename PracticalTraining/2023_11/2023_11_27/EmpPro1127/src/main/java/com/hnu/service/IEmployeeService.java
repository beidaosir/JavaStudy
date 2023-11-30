package com.hnu.service;


import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import com.hnu.vo.PageBean;

import java.util.List;

public interface IEmployeeService {

    boolean add(Employee employee);
    boolean update(Employee employee);
    boolean del(Integer empno);

    Employee findById(Integer empno);
    List<Employee> findAll();
    PageBean<Employee> findByPage(EmployeeQuery query);
    boolean delBatch(Integer[] empnos) throws Exception;

}
