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

    //条件查询
    List<Employee> listEmp(EmployeeQuery query);

    //动态sql  测试set标签
    int updateEmp(Employee employee);

    //批量删除  []
    int delBatch(int[] ids);

    //批量添加
    int addBatch(List<Employee> employeeList);


}
