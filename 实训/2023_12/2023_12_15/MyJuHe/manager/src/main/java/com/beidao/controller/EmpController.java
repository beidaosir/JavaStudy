package com.beidao.controller;

import com.beidao.po.Emp;
import com.beidao.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController{

    @Autowired
    IEmpService empService;

    @GetMapping("/getEmp/{id}")
    public Emp getEmp(@PathVariable("id") Integer empno){
        /*Emp emp = new Emp();
        emp.setEmpno(1001);
        emp.setEname("张三");*/

        Emp emp = empService.getById(empno);

        return emp;
    }
}
