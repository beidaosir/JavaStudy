package cn.neusoft.config;

import cn.neusoft.bean.Student;
import cn.neusoft.controller.StudentController;
import cn.neusoft.mapper.StudentMapper;
import cn.neusoft.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public StudentMapper studentMapper(){
        return new StudentMapper();
    }

    @Bean
    public StudentService studentService(){
        StudentService studentService = new StudentService();
        studentService.setStudentMapper1(studentMapper());
        return studentService;
    }

    @Bean
    public StudentController studentController(){
        StudentController studentController = new StudentController();
        studentController.setStudentService(studentService());
        return studentController;
    }

}
