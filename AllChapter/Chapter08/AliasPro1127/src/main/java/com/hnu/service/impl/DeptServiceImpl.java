package com.hnu.service.impl;

import com.hnu.mapper.DeptMapper;
import com.hnu.pojo.Dept;
import com.hnu.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//部门业务实现类
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    //service不能操作数据库 需要调用mapper来操作
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //补全数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
}