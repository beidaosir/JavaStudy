package com.hnu.test;


import com.hnu.bean.Student;
import com.hnu.dao.StudentDao;
import com.hnu.dao.impl.StudentDaoImpl;

import java.util.List;

public class StudentDaoTest {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();


        //查找所有学生信息
       /* List<Student> all = studentDao.getAll();
        for (Student student: all) {
            System.out.println(student);
        }*/


        //通过id查找学生信息
        /*Student student = studentDao.getById(1);
        System.out.println(student);*/

        //存储学生信息
        /*Student student = new Student(null,1008,"asc",1);
        int save = studentDao.save(student);
        System.out.println("添加了"+save+"条记录");*/

        //修改
        /* Student student = new Student(1,1001,"张三",1);
        int update = studentDao.update(student);
        System.out.println("修改了"+update+"条记录");*/

        //删除
        int remove = studentDao.remove(8);
        System.out.println("删除了"+remove+"条记录");


    }

}
