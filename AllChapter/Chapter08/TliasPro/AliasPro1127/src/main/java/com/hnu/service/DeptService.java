package com.hnu.service;

import com.hnu.pojo.Dept;
import com.hnu.pojo.Result;

import java.util.List;

//部门业务规则
public interface DeptService {

    //查询全部部门数据
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);
}