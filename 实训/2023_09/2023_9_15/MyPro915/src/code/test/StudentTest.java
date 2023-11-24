package code.test;

public class StudentTest {

    public static void main(String[] args) {

        Student s1 = new Student(" ",-20,'w');
        s1.setName("张三");
        String name = s1.getName();
        System.out.println("姓名：" + name);


    /*   s1.name = " ";
        s1.age = -20;
        s1.gender = 'w';
*/
        s1.showInfo();
    }
}
