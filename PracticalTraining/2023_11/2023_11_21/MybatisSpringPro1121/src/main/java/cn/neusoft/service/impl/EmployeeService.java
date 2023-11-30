package cn.neusoft.service.impl;

import cn.neusoft.mapper.EmployeeMapper;
import cn.neusoft.po.Employee;
import cn.neusoft.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        int add = employeeMapper.add(employee);
//        int i = 10/0;
        int add1 = employeeMapper.add(employee);
        return add>0;
    }

    @Transactional(readOnly = true)  //设置为只读
    @Override
    public Employee findById(Integer empno) {

        if (empno==null){
            return null;
        }

        return employeeMapper.findById(empno);
    }
}
