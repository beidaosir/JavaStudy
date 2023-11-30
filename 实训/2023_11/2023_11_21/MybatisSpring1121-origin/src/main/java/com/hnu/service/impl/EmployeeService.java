package com.hnu.service.impl;


import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;

import com.hnu.service.IEmployeeService;

import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class EmployeeService implements IEmployeeService {

    SqlSession session;
    EmployeeMapper employeeMapper;


    public EmployeeService(){
        session = MybatisUtil.getSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
    }

    public boolean add(Employee employee) {

        if (employee==null){
            return false;
        }

        try {
            int add = employeeMapper.add(employee);
            session.commit();
            return add>0;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();

        }
        return false;
    }

    public Employee findById(Integer empno) {

        if (empno==null){
            return null;
        }

        try {
            return employeeMapper.findById(empno);
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            session.close();

        }

        return null;
    }
}
