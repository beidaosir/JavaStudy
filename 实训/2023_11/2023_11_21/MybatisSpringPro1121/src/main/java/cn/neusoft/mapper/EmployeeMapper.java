package cn.neusoft.mapper;

import cn.neusoft.po.Employee;

public interface EmployeeMapper {

    int add(Employee employee);
    Employee findById(Integer empno);

}
