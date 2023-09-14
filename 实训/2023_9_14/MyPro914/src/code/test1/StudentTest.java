package code.test1;
/*

测试类中会有程序入口
 */
public class StudentTest {

    public static void main(String[] args) {

        //用Student类创建学生对象
        //数据类型  变量名 = new 数据类型();
        Student s1 = new Student();

        //给对象的属性赋值
        s1.name = "张三";
        s1.number =1001;
        s1.age = 20;
        s1.gender = '男';
        s1.major = "计科";

        System.out.println("姓名："+s1.name);

        s1.eat();
        s1.study();

        Student s2 = new Student();
        s2.name = "李四";

        s2.sleep();
    }
}
