package cn.neusoft.service;

import cn.neusoft.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

//    @Autowired    //相当于<property name="studentMapper1" ref="studentMapper">
    public void setStudentMapper1(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void add(){
        System.out.println("开启事务");
        studentMapper.add();
        System.out.println("提交事务");
    }

}
