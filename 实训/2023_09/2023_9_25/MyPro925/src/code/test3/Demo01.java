package code.test3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Demo01 {

    public static void main(String[] args) {

        /*
        创建Student对象  设置参数
        将集合保存在文件中
         */
        Student stu1 = new Student(1,"张三",95);
        Student stu2 = new Student(2,"李四",90.5);
        Student stu3 = new Student(3,"王五",87);
        Student stu4 = new Student(4,"赵六",59.5);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        Collections.addAll(studentArrayList,stu1,stu2,stu3,stu4);

        System.out.println(studentArrayList);



        //执行写入操作
        //需要对象输出流
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("对象流.txt"));
            objectOutputStream.writeObject(studentArrayList);

            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
