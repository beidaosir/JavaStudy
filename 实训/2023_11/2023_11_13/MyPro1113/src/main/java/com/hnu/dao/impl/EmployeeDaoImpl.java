package com.hnu.dao.impl;

import com.hnu.dao.EmployeeDao;
import com.hnu.po.Employee;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    public int add(Employee employee) {
        SqlSession session = MybatisUtil.getSession();
        int insert = session.insert("EmployeeMapper.add", employee);
        session.commit();
        return insert;
    }

    public int update(Employee employee) {
        SqlSession session = MybatisUtil.getSession();
        int update = session.update("EmployeeMapper.update", employee);
        session.commit();
        return update;
    }



    public int del(Integer id) {
        SqlSession session = MybatisUtil.getSession();
        int delete = session.delete("EmployeeMapper.del", id);
        session.commit();
        return delete;
    }


    public Employee getById(Integer id) {
        SqlSession session = MybatisUtil.getSession();
        return session.selectOne("EmployeeMapper.getById", id);
    }

    public List<Employee> getALl() {
        SqlSession session = MybatisUtil.getSession();
        return session.selectList("EmployeeMapper.getAll");
    }

}
