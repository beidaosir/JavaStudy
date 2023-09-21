package code.test2;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Demo01 {

    public static void main(String[] args) {

        /*
        public TreeSet(Comparator<? super E> comparator)
        让自定义类的对象可比：
        1、实体类自己实现Comparable接口
        2、创建一个比较器XXXComparator 可以比较对应的实体类型的对象
           创建StudentComparetor类 实现 Comparator接口
         */

        //可以比较学生的姓名和年龄
        Comparator studentComparetor = new StudentComparetor();

        //创建TreeSet时传入一个比较器对象
        TreeSet<Student> stuTree = new TreeSet<>(studentComparetor);
        Student s1 = new Student("white", 25);
        Student s2 = new Student("jack", 22);
        Student s3 = new Student("apple", 22);
        Student s4 = new Student("rose", 23);
        Student s5 = new Student("apple", 20);
        Collections.addAll(stuTree, s1, s2, s3, s4, s5);

        System.out.println(stuTree);

    }

}
