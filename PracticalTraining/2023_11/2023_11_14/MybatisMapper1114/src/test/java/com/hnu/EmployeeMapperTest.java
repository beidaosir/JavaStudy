package com.hnu;


import com.hnu.mapper.EmployeeMapper;
import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeMapperTest {

    @Test
    public void testGetAll(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.getAll();
        for (Employee employee:list) {
            System.out.println(employee);
        }
    }

    @Test
    public void testDel(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int del = mapper.del(9999);
        session.commit();
        System.out.println(del);
    }

    @Test
    public void testGetByName(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.getByEname("李");
        for (Employee employee:list) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetByCondition(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        EmployeeQuery query = new EmployeeQuery("A",30,1000.0,2000.0);
        List<Employee> list = mapper.getByCondition(query);
        for (Employee employee:list) {
            System.out.println(employee);
        }
    }


    @Test
    public void testGetCount(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int count = mapper.getCount();
        System.out.println("总记录数："+count);
    }

    @Test
    public void testGetByEmpno(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        String ename = mapper.getByEmpno(1111);
        System.out.println("姓名为："+ename);
    }

    @Test
    public void testAdd(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(null, "麦克", "销售", 7788, new Date(), 6000.0, 1000.0, 30);
        int add = mapper.add(employee);
        session.commit();
        System.out.println(add);
        System.out.println(employee.getEmpno());

    }

    @Test
    public void testGetByCondition2(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        EmployeeQuery query = new EmployeeQuery();
        query.setHighSal(2500.0);
        query.setDeptno(30);
        List<Employee> list = mapper.getByCondition(query);
        for (Employee employee:list) {
            System.out.println(employee);
        }
    }


    //测试条件查询  choose
    @Test
    public void testListEmp(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        EmployeeQuery query = new EmployeeQuery();
//        query.setEname("A");
        query.setDeptno(30);
        List<Employee> list = mapper.listEmp(query);
        for (Employee employee:list) {
            System.out.println(employee);
        }
    }

    /*
    测试添加
     */
    @Test
    public void testAdd2(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEname("Rose");
        employee.setHiredate(new Date());
        int add = mapper.add(employee);
        session.commit();
        System.out.println(add);
    }

    @Test
    public void testUpdateEmp(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEname("Rose");
        employee.setJob("销售");
        employee.setSal(5000.0);
        employee.setEmpno(7939);
        int i = mapper.updateEmp(employee);
        session.commit();
        System.out.println(i);
    }

    @Test
    public void testDelBatch(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int[] ids = {7937,7938,7939};
        int i = mapper.delBatch(ids);
        session.commit();
        System.out.println(i);
    }

    @Test
    public void testAddBatch(){
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(null,"张三","销售",7788,
                new Date(),8000.0,1000.0,10));
        employeeList.add(new Employee(null,"李四","销售",7788,
                new Date(),8000.0,1000.0,10));
        employeeList.add(new Employee(null,"王五","销售",7788,
                new Date(),8000.0,1000.0,10));
        int i = mapper.addBatch(employeeList);
        session.commit();
        System.out.println(i);
    }

}
