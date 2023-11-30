package cn.neusoft.test;

import cn.neusoft.controller.StudentController;
import cn.neusoft.mapper.StudentMapper;
import cn.neusoft.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest3 {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/springconfig5.xml");
//        StudentMapper mapper = context.getBean("studentMapper",StudentMapper.class);
//        mapper.add();

//        StudentService service = context.getBean(StudentService.class);
//        service.add();

        StudentController studentController = context.getBean("studentController", StudentController.class);
        studentController.add();
    }

}
