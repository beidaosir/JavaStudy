package cn.neusoft.controller;

import cn.neusoft.service.StudentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//@Component
@Controller
public class StudentController {

    @Resource
    StudentService studentService;

//    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void add(){
        System.out.println("接收请求参数");
        studentService.add();
        System.out.println("给前端响应");
    }

}
