package cn.neusoft.mapper;

import cn.neusoft.po.Employee;
import cn.neusoft.query.EmployeeQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Insert("insert into emp(ename,job,hiredate,sal) values(#{ename},#{job},#{hiredate},#{sal})")
    int add(Employee employee);
    @Update("update emp set ename=#{ename},job=#{job},hiredate=#{hiredate},sal=#{sal} where empno=#{empno}")
    int update(Employee employee);
    @Delete("delete from emp where empno=#{empno}")
    int del(Integer empno);

    @Select("<script>" +
            "   select empno,ename,job,hiredate,sal from emp" +
            "   <where>" +
            "       <if test=\"ename!=null and ename!=''\">" +
            "           ename like CONCAT('%',#{ename},'%')" +
            "       </if>" +
            "   </where>" +
            "   order by empno desc" +
            "</script>")
    List<Employee> getByCondition(EmployeeQuery employeeQuery);

    @Select("select empno,ename,job,hiredate,sal from emp where empno=#{empno}")
    Employee getById(Integer empno);

}
