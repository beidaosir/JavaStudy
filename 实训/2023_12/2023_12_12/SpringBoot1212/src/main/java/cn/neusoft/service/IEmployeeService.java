package cn.neusoft.service;

import cn.neusoft.po.Employee;
import cn.neusoft.query.EmployeeQuery;
import cn.neusoft.vo.PageBean;

public interface IEmployeeService {

    boolean add(Employee employee);
    boolean update(Employee employee);
    boolean del(Integer empno);
    Employee getById(Integer empno);
    PageBean<Employee> getByPage(EmployeeQuery query);
}
