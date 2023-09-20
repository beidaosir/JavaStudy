package cn.neusoft.test1;

public class StudentDemo09 {

    public static void main(String[] args) {
        Student student1 = new Student(1001,"张三");
        Student student2 = new Student(1001,"张三");

        System.out.println(student1.equals(student2));
    }

}
