package com.hnu.service.impl;

import com.hnu.mapper.AdminMapper;
import com.hnu.po.Admin;
import com.hnu.service.AdminService;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class AdminServiceImpl implements AdminService {

    SqlSession session;
    AdminMapper adminMapper;

    public AdminServiceImpl(){
        session = MybatisUtil.getSession();
        adminMapper = session.getMapper(AdminMapper.class);
    }

    @Override
    public Admin login(String username, String password) {

        if (username==null || "".equals(username) || password==null || "".equals(password)){
            return null;
        }

        try{
          return adminMapper.getByCondition(username,password);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return null;
    }
}
