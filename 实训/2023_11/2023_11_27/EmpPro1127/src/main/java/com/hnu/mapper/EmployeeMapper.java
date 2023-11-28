package com.hnu.mapper;

import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeMapper {

    @Insert("insert into emp(ename,job,hiredate,sal) values(#{ename},#{job},#{hiredate},#{sal})")
    int add(Employee employee);

    @Update("update emp set ename=#{ename},job=#{job},hiredate=#{hiredate},sal=#{sal} where empno=#{empno}")
    int update(Employee employee);

    @Select("select empno,ename,job,hiredate,sal from emp where empno = #{empno}")
    Employee findById(Integer empno);

    @Select("select empno,ename,job,hiredate,sal from emp")
    List<Employee> findAll();

    @Delete("delete from emp where empno = #{empno}")
    int del(Integer empno);

    int getCount(EmployeeQuery query);

    List<Employee> getByPage(EmployeeQuery query);

}