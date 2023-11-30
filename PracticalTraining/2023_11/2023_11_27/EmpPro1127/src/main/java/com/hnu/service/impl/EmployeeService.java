package com.hnu.service.impl;


import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import com.hnu.service.IEmployeeService;
import com.hnu.vo.PageBean;
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

    @Transactional(readOnly = true)
    @Override
    public PageBean<Employee> findByPage(EmployeeQuery query) {

        if (query==null){
            return null;
        }

        if (query.getCurrentPage()==null){
            query.setCurrentPage(1);
        }

        if (query.getPageNumber()==null){
            query.setPageNumber(5);
        }

        PageBean<Employee> employeePageBean = new PageBean<>();

        //查询总记录
        int count = employeeMapper.getCount(query);
        employeePageBean.setTotalRows(count);

        //计算总页数
        int totalPages = count % query.getPageNumber() == 0 ? count / query.getPageNumber() : count / query.getPageNumber() + 1;
        employeePageBean.setTotalPages(totalPages);

        //查询当页集合
        List<Employee> employeeList = employeeMapper.getByPage(query);
        employeePageBean.setData(employeeList);

        return employeePageBean;
    }

    @Transactional
    @Override
    public boolean delBatch(Integer[] empnos) throws Exception {

        if (empnos==null || empnos.length==0){
            return false;
        }

        for (Integer empno:empnos ) {
            int del = employeeMapper.del(empno);
            if (del<=0){
                throw new Exception(empno+"删除失败，需要回滚");
            }
        }

        return true;
    }
}