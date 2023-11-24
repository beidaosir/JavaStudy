package code.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Demo04 {

    public static void main(String[] args) {

        /*
        创建几个Student对象放入集合中
         */
        ArrayList<Student> stuList = new ArrayList<>();

        //(String name, String number, int age, char gender, String major)

        Student s1 = new Student("jack","1001",20,'男',"软件工程");

        Student s2 = new Student("tom","1002",20,'男',"软件工程");
        Student s3 = new Student("mike","1003",20,'男',"软件工程");

        Collections.addAll(stuList,s1,s2,s3);


        System.out.println(stuList);
        //        stuList.add(1);   //限定泛型之后添加的元素只能是所指定的类型

//        Student student = stuList.get(1);  //指定泛型之后获取的元素就是指定的类型

        for (Student stu:stuList) {
            System.out.println("学号：" + stu.getNumber() + "   姓名：" + stu.getName());
        }


    }
}
