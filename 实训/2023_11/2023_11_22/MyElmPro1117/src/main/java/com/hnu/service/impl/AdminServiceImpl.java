package com.hnu.service.impl;

import com.hnu.mapper.AdminMapper;
import com.hnu.po.Admin;
import com.hnu.service.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;



    @Override
    public Admin login(String username, String password) {

        if (username==null || "".equals(username) || password==null || "".equals(password)){
            return null;
        }

        return adminMapper.getByCondition(username,password);
    }
}
