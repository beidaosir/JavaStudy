package com.hnu.mapper;

import com.hnu.po.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select empno,ename,job,sal from emp")
    List<Employee> getAll();
}