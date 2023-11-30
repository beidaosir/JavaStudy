package com.hnu.service.impl;


import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;

import com.hnu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Transactional
    @Override
    public boolean add(Employee employee) {

        if (employee==null){
            return false;
        }
        return employeeMapper.add(employee)>0;
    }

    @Transactional
    @Override
    public boolean update(Employee employee) {

        if (employee==null){
            return false;
        }

        return employeeMapper.update(employee)>0;
    }

    @Transactional
    @Override
    public boolean del(Integer empno) {
        if (empno==null){
            return false;
        }

        return employeeMapper.del(empno)>0;
    }

    @Transactional(readOnly = true)  //设置为只读
    @Override
    public Employee findById(Integer empno) {

        if (empno==null){
            return null;
        }

        return employeeMapper.findById(empno);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }
}