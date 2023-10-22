package com.hnu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {

    private static Connection connection;

    static {
        //加载驱动  用到一点反射的知识
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库连接
            String url = "jdbc:mysql://localhost:3306/elmdb";
            String username = "root";
            String password = "11111";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConn(){
        return connection;
    }

}
