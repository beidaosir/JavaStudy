package code.coll;

import java.util.HashMap;
import java.util.Set;

/*需求:
创建一个HashMap集合，
键是学生对象(Student)，值是籍贯(string)
存储三个键值对元素，并遍历
要求:同姓名，同年龄认为是同一个学生*/
public class HashMapDemo01 {
    public static void main(String[] args) {

        //1.创建HashMap的对象

        HashMap<Student1,String> hm = new HashMap<>();
        //2.创建学生对象

        Student1 s1 = new Student1("zhangsan",23);
        Student1 s2 = new Student1("lisi",24);
        Student1 s3 = new Student1("wangwu",25);
        //3.添加元素

        hm.put(s1,"江苏");
        hm.put(s2,"浙江");
        hm.put(s3,"福建");

        //4.遍历集合
        Set<Student1>  keys = hm.keySet();
        for (Student1 key:keys) {
            String value = hm.get(key);
            System.out.println(key+":"+value);
        }

    }
}
