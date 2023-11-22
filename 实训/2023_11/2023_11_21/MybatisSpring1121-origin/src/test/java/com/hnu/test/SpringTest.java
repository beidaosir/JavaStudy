package com.hnu.test;


import org.junit.Test;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource);
    }

}