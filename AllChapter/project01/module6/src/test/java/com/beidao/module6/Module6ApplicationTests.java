package com.beidao.module6;

import com.beidao.module6.dto.Student;
import com.beidao.module6.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Module6ApplicationTests {


    @Autowired
    StudentMapper studentMapper;


    @Test // 测试方法
    public void test1() {

        studentMapper.findAll().forEach(System.out::println);
    }

    @Test
    public void test2() {

        Student stu = studentMapper.findById(1);
        System.out.println(stu.getId() + " " + stu.getName());
    }


}
