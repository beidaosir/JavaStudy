package com.hnu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;
import com.hnu.query.BaseQuery;
import com.hnu.query.EmployeeQuery;
import com.hnu.service.IEmployeeService;
import com.hnu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @Override
    public PageBean<Employee> getByPage(EmployeeQuery query) {

        PageBean<Employee> pageBean = new PageBean<>();

        //开始分页
        Page<Employee> page = PageHelper.startPage(query.getPageNow(), query.getPageSize());

        employeeMapper.getAll();

        pageBean.setTotalRows((int)page.getTotal());
        pageBean.setTotalPages(page.getPages());
        pageBean.setData(page.getResult());

        return pageBean;
    }
}
