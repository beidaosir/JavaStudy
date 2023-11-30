package com.hnu.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo06 {

    public static void main(String[] args) {

        Connection conn = JDBCUtils.getConn();
        System.out.println(conn);

        List<Student> studentList = new ArrayList<>();

        //查询操作
        String sql = "select id,sno,sname,classid from t_student where id = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //执行查询语句得到一个结果集对象
            ResultSet resultSet = preparedStatement.executeQuery();

            //结果集中封装了查询到的二维表
            while (resultSet.next()){
                int id = resultSet.getInt(1);//每一行的第一个下标对应位置的值
                int sno = resultSet.getInt("sno"); //根据列名称获取
                String sname = resultSet.getString("sname");
                int classid = resultSet.getInt("classid");
                System.out.println(id+" "+sno+" "+sname+" "+classid);

                Student student = new Student(id,sno,sname,classid);
                studentList.add(student);

            }
            //打印集合查看
            for (Student student: studentList) {
                System.out.println(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
