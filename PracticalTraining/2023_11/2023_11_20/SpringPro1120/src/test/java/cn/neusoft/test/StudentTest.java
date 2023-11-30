package cn.neusoft.test;

import cn.neusoft.controller.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/springconfig2.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.add();
    }

    @Test
    public void test03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/springconfig3.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.add();
    }

}
