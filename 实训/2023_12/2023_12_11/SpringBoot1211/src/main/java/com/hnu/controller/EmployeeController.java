package com.hnu.controller;

import com.hnu.po.Employee;
import com.hnu.query.BaseQuery;
import com.hnu.query.EmployeeQuery;
import com.hnu.service.IEmployeeService;
import com.hnu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> all(){
        return employeeService.getAll();
    }

    @GetMapping("/page")
    public PageBean<Employee> all(EmployeeQuery query){
        return employeeService.getByPage(query);
    }




}
