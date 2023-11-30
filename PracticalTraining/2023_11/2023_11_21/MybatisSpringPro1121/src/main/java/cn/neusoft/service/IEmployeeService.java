package cn.neusoft.service;

import cn.neusoft.po.Employee;

public interface IEmployeeService {

    boolean add(Employee employee);
    Employee findById(Integer empno);

}
