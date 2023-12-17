package com.hnu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnu.mapper.EmpMapper;
import com.hnu.po.Emp;
import com.hnu.service.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class EmpServiceTest {

    @Autowired
    IEmpService empService;

    @Test
    public void test01(){
        Emp emp = empService.getById(7369);
        System.out.println(emp);
    }

    @Test
    public void test02(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("ename","SCOTT");
        Emp emp = empService.getOne(queryWrapper);
        System.out.println(emp);
    }

    @Test
    public void test03(){
        Emp emp = new Emp();
        emp.setEmpno(7955);
        //emp.setEname("张三丰");
        emp.setJob("销售");
        emp.setHiredate(new Date());
        emp.setSal(6000.0);
        boolean b = empService.saveOrUpdate(emp);
        System.out.println(b);

    }

    @Test
    public void test04(){
        IPage<Emp> page = empService.page(new Page<>(1, 5));
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        page.getRecords().forEach(System.out::println);

    }

    @Autowired
    EmpMapper empMapper;

    @Test
    public void test05(){
        Emp emp = empMapper.getById(7900);
        System.out.println(emp);
    }


}
