package com.hnu.controller;

import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import com.hnu.service.IEmployeeService;
import com.hnu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController   //相当于给所有方法都加了@ResponseBody注解
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    //@RequestBody请求参数为json
    @PostMapping("/save")
    public String addOrUpdate(@RequestBody Employee employee){
        boolean i = false;
        if (employee.getEmpno()==null){
            i = employeeService.add(employee);
        }else{
            i = employeeService.update(employee);
        }
        return i?"success":"fail";
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable("id") Integer empno){
        return employeeService.del(empno)?"success":"fail";
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Integer empno){
        return employeeService.findById(empno);
    }

    @PostMapping("/page")
    public PageBean<Employee> getByPage(@RequestBody  EmployeeQuery query){
        return employeeService.findByPage(query);
    }

}
