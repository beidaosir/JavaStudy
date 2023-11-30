package code.test;

/**
 * public 访问修饰符  公共的
 * private 访问修饰符  私有的   使用范围就是本类
 * 封装：
 *   1、用private修饰成员属性   在其他类中就不能直接访问了
 *   2、提供public的getter、setter方法
 *      在其他类中可以通过这个公共的赋值、取值方法对属性进行操作
 */

public class Student {

    /*
    private修饰之后name在测试类中访问不到了
    但是我们依然有对name重新赋值的需求
    需要提供public赋值取值的方法
    */

    private String name; //private修饰之后在本类中可以访问
    int age;
    char gender;


    public Student(String name, int age, char gender){

        if (name != null && !"".equals(name)){
            this.name = name;
        }else {
            System.out.println("姓名不可以为空，应该给出合理的姓名,例如：张三");
            this.name = "无名";

        }

        if (age >= 6 && age <= 60){
            this.age = age;
        }else {
            System.out.println("学生的招收年龄在6~60之间，您给的值不合理，已经为您设置年龄18");
            this.age = 18;
        }

        if (gender == '男' || gender == '女'){
            this.gender = gender;
        }else {
            System.out.println("性别应该为男或者女，不接收其他字符，已经为您设置为男");
            this.gender = '男';
        }
    }

    /**
     * name属性的赋值方法
     */

    public void setName(String name){
        if(name != null && !"".equals(name)){
            this.name = name;
        }else {
            System.out.println("姓名不可以为空，应该给出合理的姓名,例如：张三");
            this.name = "无名";
        }
    }

    /**
     * name属性的取值方法
     */

    public String getName(){
        return name;
    }


    void showInfo(){
        System.out.println(name + " " + age + " " + gender);
    }

}
