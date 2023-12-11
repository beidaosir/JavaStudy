package com.hnu.mapper;

import com.hnu.po.Employee;
import com.hnu.query.EmployeeQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select empno,ename,job,sal from emp")
    List<Employee> getAll();

    @Select("select empno,ename,job,sal from emp where ename like CONCAT('%',#{ename},'%')")
    List<Employee> getByCondition(EmployeeQuery employeeQuery);

    @Options(useGeneratedKeys = true, keyColumn = "empno", keyProperty = "empno")
    @Insert("insert into emp(ename,job,sal) values(#{ename},#{job},#{sal})")
    int add(Employee employee);
}