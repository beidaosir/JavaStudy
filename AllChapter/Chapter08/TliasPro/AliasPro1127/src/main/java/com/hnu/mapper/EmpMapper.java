package com.hnu.mapper;

import com.hnu.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    //获取总记录数
   /* @Select("select count(*) from emp")
    public Long count();*/

    //获取当前页的结果列表
/*
    @Select("select * from emp limit #{start}, #{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);
*/

    @Select("select * from emp")
    public List<Emp> list();

}