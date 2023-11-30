package com.hnu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo03 {

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
        Student student = new Student(7,1006,"rose",1);

        String sql = "update t_student set sno=?,sname=?,classid=? where id=?";

        //使用预处理的方式处理sql
        /*
        PreparedStatement
         1、预处理sql  给？占位符的地方替换变量值
         2、发起sql的执行
         */
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //给？所在的位置设置值  第一个参数是？的下标 从1开始  第二个参数是替换？的值
        preparedStatement.setInt(1,student.getSno()); //1006
        preparedStatement.setString(2,student.getSname()); //rose
        preparedStatement.setInt(3,student.getClassid()); //1
        preparedStatement.setInt(4,student.getId()); //7


        int i = preparedStatement.executeUpdate();
        System.out.println("修改了"+i+"条记录");
    }

}

