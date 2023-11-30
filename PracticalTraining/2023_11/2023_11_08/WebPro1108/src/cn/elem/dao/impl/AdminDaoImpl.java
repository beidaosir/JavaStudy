package cn.elem.dao.impl;

import cn.elem.bean.Admin;
import cn.elem.dao.AdminDao;
import cn.elem.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    /**
     * 根据账户查询管路员对象
     * @param adminName
     * @return
     */
    @Override
    public Admin getByName(String adminName) {

        String sql = "SELECT adminId,adminName,`password`,role FROM t_admin WHERE adminName=?";

        Connection conn = JdbcUtils.getConn();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,adminName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int adminId = resultSet.getInt("adminId");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");

                return new Admin(adminId,adminName,password,role);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
