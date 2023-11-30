package com.hnu.controller;

import com.hnu.po.Employee;
import com.hnu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @RequestMapping("/add")
    public String add(Employee employee){
        boolean add = employeeService.add(employee);
        return "redirect:/emp/all";
    }

    @RequestMapping("/all")
    public String findAll(Model model){
        List<Employee> list = employeeService.findAll();
        model.addAttribute("list",list);
        return "empList";
    }

}