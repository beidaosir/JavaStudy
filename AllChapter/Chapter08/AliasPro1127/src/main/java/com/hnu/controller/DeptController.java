package com.hnu.controller;

import com.hnu.pojo.Dept;
import com.hnu.pojo.Result;
import com.hnu.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//部门管理控制器
@Slf4j
@RestController
public class DeptController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);//可以使用注解代替@Slf4j

    @Autowired
    private DeptService deptService;

    /*
    查询部门数据
     */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求方式为get
    @GetMapping("/depts")
    public Result list(){
        log.info("查询全部部门数据");

        //调用service查询部门数据
        List<Dept> deptList = deptService.list();


        return Result.success(deptList);
    }


    /*
    删除部门数据
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }


    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        //记录日志
        log.info("新增部门：{}",dept);
        //调用service层添加功能
        deptService.add(dept);
        //响应
        return Result.success();
    }




}