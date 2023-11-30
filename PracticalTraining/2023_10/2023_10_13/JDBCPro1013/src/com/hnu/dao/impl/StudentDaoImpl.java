package com.hnu.dao.impl;



import com.hnu.bean.Student;
import com.hnu.dao.StudentDao;
import com.hnu.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public int save(Student student){
        Connection connection = JDBCUtils.getConn();
        String sql = "INSERT INTO t_student(sno,sname,classid) VALUES(?,?,?)";

        //使用预处理的方式处理sql
        /*
        PreparedStatement
         1、预处理sql  给？占位符的地方替换变量值
         2、发起sql的执行
         */
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //给？所在的位置设置值  第一个参数是？的下标 从1开始  第二个参数是替换？的值
            preparedStatement.setInt(1,student.getSno());
            preparedStatement.setString(2,student.getSname());
            preparedStatement.setInt(3,student.getClassid());

            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public int update(Student student) {
        Connection connection = JDBCUtils.getConn();
        String sql = "update t_student set sno=?,sname=?,classid=? where id=?";

        //使用预处理的方式处理sql
        /*
        PreparedStatement
         1、预处理sql  给？占位符的地方替换变量值
         2、发起sql的执行
         */
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //给？所在的位置设置值  第一个参数是？的下标 从1开始  第二个参数是替换？的值
            preparedStatement.setInt(1,student.getSno()); //1006
            preparedStatement.setString(2,student.getSname()); //rose
            preparedStatement.setInt(3,student.getClassid()); //1
            preparedStatement.setInt(4,student.getId()); //7

            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public int remove(Integer id) {
        Connection connection = JDBCUtils.getConn();
        String sql = "delete from t_student where id=?";

        //使用预处理的方式处理sql
        /*
        PreparedStatement
         1、预处理sql  给？占位符的地方替换变量值
         2、发起sql的执行
         */
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Student> getAll() {
        Connection conn = JDBCUtils.getConn();

        List<Student> studentList = new ArrayList<>();

        //进行查询操作
        String sql = "SELECT id,sno,sname,classid FROM t_student";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //执行查询语句得到一个结果集对象
            ResultSet resultSet = preparedStatement.executeQuery();
            /*
            结果集中封装了查询到的二维表
             */
            while (resultSet.next()) {
                int id = resultSet.getInt(1);//每一行的第一个下标对应位置的值
                int sno = resultSet.getInt("sno"); //根据列名称获取
                String sname = resultSet.getString("sname");
                int classid = resultSet.getInt("classid");

                //获取到每一行的字段值  封装成一个学生对象
                Student student = new Student(id, sno, sname, classid);
                //将学生对象放入集合
                studentList.add(student);
            }

            return studentList;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student getById(Integer id) {
        Connection conn = JDBCUtils.getConn();

        //进行查询操作
        String sql = "SELECT id,sno,sname,classid FROM t_student WHERE id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //预处理sql 给？设置值
            preparedStatement.setInt(1,id);

            //执行查询语句得到一个结果集对象
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int sid = resultSet.getInt(1);//每一行的第一个下标对应位置的值
                int sno = resultSet.getInt("sno"); //根据列名称获取
                String sname = resultSet.getString("sname");
                int classid = resultSet.getInt("classid");

                //获取到每一行的字段值  封装成一个学生对象
                return new Student(sid,sno,sname,classid);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
