package cn.neusoft.test;

import cn.neusoft.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SpringTest {

    @Test
    public void test01(){
        //获取一个容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/springconfig.xml");
        Object birthday = applicationContext.getBean("birthday");
        System.out.println(birthday);
    }

    @Test
    public void test02(){
        //获取一个容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/springconfig.xml");
        System.out.println("------容器构建完毕--------");
        Object user01 = applicationContext.getBean("user01");
        System.out.println(user01);

        Object user011 = applicationContext.getBean("user01");
        System.out.println(user011);
    }

    @Test
    public void test03(){
        //获取一个容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/springconfig.xml");
        Object user01 = applicationContext.getBean("user02");
        System.out.println(user01);

        Object uname = applicationContext.getBean("uname");
        System.out.println(uname);

//        Object user03 = applicationContext.getBean("user03");
//        System.out.println(user03);
//
//        Object user04 = applicationContext.getBean("user04");
//        System.out.println(user04);
//
//        Object user05 = applicationContext.getBean("user05");
//        System.out.println(user05);
    }

    @Test
    public void test04() throws Exception {

        Class<?> aClass = Class.forName("cn.neusoft.bean.User");
        //获取空构造
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);

        //username1
        String pName1 = "username1";
        String setMehodName1 = "set"+String.valueOf(pName1.charAt(0)).toUpperCase()+pName1.substring(1);
        System.out.println("set方法名："+setMehodName1);
        Method method1 = aClass.getMethod(setMehodName1, String.class);
        method1.invoke(o, "张三");

        System.out.println(o);

        String pName2 = "password";
        String setMehodName2 = "set"+String.valueOf(pName2.charAt(0)).toUpperCase()+pName2.substring(1);
        System.out.println("set方法名："+setMehodName2);
        Method method2 = aClass.getMethod(setMehodName2, String.class);
        method2.invoke(o, "67798898");

        System.out.println(o);

        Constructor<?> constructor1 = aClass.getConstructor(String.class, String.class);
        Object o2 = constructor1.newInstance("李四", "321563627");
        System.out.println(o2);
    }


    @Test
    public void test05() {
        //获取一个容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/springconfig.xml");
        Student stu01 = (Student)applicationContext.getBean("stu01");
        System.out.println(stu01);

        Student student = applicationContext.getBean("stu02",Student.class);
        System.out.println(student);

        Student student03 = applicationContext.getBean("stu03",Student.class);
        System.out.println(student03);
    }
}
