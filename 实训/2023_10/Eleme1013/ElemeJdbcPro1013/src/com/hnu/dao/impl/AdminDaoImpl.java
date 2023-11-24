package com.hnu.dao.impl;

import com.hnu.bean.Admin;
import com.hnu.dao.AdminDao;
import com.hnu.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin login(String adminName, String password) {

        String sql = "select * from t_admin where adminName = ? and password = ?";

        //1.获取链接
        Connection conn = JDBCUtils.getConn();

        //2.获取预处理对象
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //3.给 ？ 设置值
            preparedStatement.setString(1,adminName);
            preparedStatement.setString(2,password);

            //4.执行sql
            ResultSet resultSet = preparedStatement.executeQuery();

            //5.处理结果集
            if (resultSet.next()){
                int adminId = resultSet.getInt("adminId");

                //6.返回查询到的正确结果
                return new Admin(adminId,adminName,password);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}
