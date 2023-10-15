package code.coll;

import java.util.TreeSet;

public class StudentTest {

    public static void main(String[] args) {


        //创建学生对象
        Student s1 = new Student("zhangsan", 23, 98, 92, 59);//249
        Student s2 = new Student("lisi", 24, 90, 88, 77);//255
        Student s3 = new Student("wangwu", 25, 100, 56, 90);//246
        Student s4 = new Student("zhaoliu", 26, 85, 99, 55);//239

        //创建集合
        TreeSet<Student> ts = new TreeSet<>();

        //添加元素

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);

        //打印集合
        //System.out.println(ts);

        for (Student stu: ts) {
            System.out.println(stu);
        }
    }
}
