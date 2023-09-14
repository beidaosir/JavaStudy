package code.test1;

public class StudentTest1 {

    public static void main(String[] args) {

        Student s1 = new Student("张三",20);
        Student s2 = new Student("李四",21);
        Student s3 = new Student();
        s3.name = "王五";


        s1.study();
        s2.study();

        Student s4 = new Student("赵六",'男',19);

        System.out.println(s4.name+" "+s4.gender+" "+s4.age);



    }
}
