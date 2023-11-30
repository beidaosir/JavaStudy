package com.hnu.test;

import com.hnu.mapper.DeptMapper;
import com.hnu.po.Dept;
import com.hnu.po.Employee;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DeptMapperTest {

    @Test
    public void testGetById(){
        SqlSession session = MybatisUtil.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = mapper.getById(10);
        System.out.println(dept);
        System.out.println("该部门所有员工列表：");
        List<Employee> empList = dept.getEmpList();
        for (Employee employee:empList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetAll(){
        SqlSession session = MybatisUtil.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> deptList = mapper.getAll();
        for (Dept dept:deptList) {
            System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLoc());
            if (dept.getDeptno()==10){
                System.out.println("--------部门员工信息--------------");
                List<Employee> empList = dept.getEmpList();
                for (Employee employee:empList) {
                    System.out.println(employee);
                }
            }
        }
    }

}

