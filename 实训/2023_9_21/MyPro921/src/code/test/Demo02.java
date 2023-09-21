package code.test;

import java.util.Collections;
import java.util.HashSet;

public class Demo02 {

    public static void main(String[] args) {

        /*
        给HashSet中装入学生对象
        只要两个对象姓名和年龄相同就认定为同一个对象 最终只存储一个
         */
        //1.创建一个HashSet

        HashSet<Student> stuSet = new HashSet<>();

        //2.创建几个学生对象添加进去  里面存在重复学生

        Student s1 = new Student("张三",20);
        Student s2 = new Student("Jack",22);
        Student s3 = new Student("Tom",21);
        Student s4 = new Student("Rose",23);
        Student s5 = new Student("张三",20);
        Collections.addAll(stuSet,s1,s2,s3,s4,s5);



        //3.输出集合的时候  重复元素只显示一个

        System.out.println(stuSet);

    }

}
