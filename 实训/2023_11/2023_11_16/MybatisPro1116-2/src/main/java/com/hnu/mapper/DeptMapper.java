package com.hnu.mapper;


import com.hnu.po.Dept;


import java.util.List;

public interface DeptMapper {

    Dept getById(Integer deptno);

    List<Dept> getAll();

}
