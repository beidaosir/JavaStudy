package com.hnu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取数据库连接
        String url = "jdbc:mysql://localhost:3306/newtest";
        String username = "root";
        String password = "11111";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);

        //添加的学生对象  封装了学生的信息
        Student student = new Student(null,1006,"杰瑞",1);

        String sql = "INSERT INTO t_student(sno,sname,classid) VALUES(?,?,?)";

        //使用预处理的方式处理sql
        /*
        PreparedStatement
         1、预处理sql  给？占位符的地方替换变量值
         2、发起sql的执行
         */
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //给？所在的位置设置值  第一个参数是？的下标 从1开始  第二个参数是替换？的值
        preparedStatement.setInt(1,student.getId());
        preparedStatement.setInt(2,student.getSno());
        preparedStatement.setString(3,student.getSname());

        int i = preparedStatement.executeUpdate();
        System.out.println("添加了"+i+"条记录");
    }

}

