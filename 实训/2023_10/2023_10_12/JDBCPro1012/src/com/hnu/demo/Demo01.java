package com.hnu.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取数据库连接
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "11111";

        Connection connection = DriverManager.getConnection(url,username,password);
        System.out.println(connection);


        Student student = new Student(null,1006,"杰瑞",1);
        String sql = "INSERT INTO student1(id,sno,sname) VALUES("+student.getId()+","+student.getSno()+",'"+student.getSname()+"')";
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println("添加了："+i+" 条记录");


    }
}
