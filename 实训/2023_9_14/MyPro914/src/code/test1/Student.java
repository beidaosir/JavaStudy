package code.test1;

/*
学生类：
    姓名、性别、学号、专业、年龄...
 */

/*
 构造方法
      每一个类都有一个默认的空参数列表的构造方法
      默认是隐藏的，需要的时候可以显式地写出来
 */
public class Student {
    //属性 全局变量
    String name;//姓名
    char gender;//性别
    int number;//学号
    String major;//专业
    int age;//年龄

    //构造方法
    /*
        构造方法：
        1.方法名和类名相同
        2.没有返回值类型
        3.构建对象时会调用构造方法
        4.空参数列表的构造方法(空构造)会默认存在，需要时显式写出即可
        5.构造方法可以重载
        6.构造方法用于初始化对象(初始化一般就是给属性做赋值操作)
        7.写了有参构造会覆盖无参构造，如果还要使用无参构造，需要显式写出
     */
    public Student(){
        System.out.println("这是Student类的空构造方法，构建对象时会默认调用该方法");

    }
    /*
    带参数的构造方法(有参构造)
     */
    public Student(String n,int a){
        name = n;
        age = a;
    }


     /*
    方法中声明的变量(包括参数列表)  只能在该方法中使用
    局部变量

    name = name; 就近在方法中寻找
    全局的name = 局部的name
    this是本类对象的引用
    this到底是本类的哪个对象   那就看this所在的方法被哪个对象调用了
      */
    public Student(String name,char gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    //方法
    void study(){
        System.out.println(name + "好好学习，天天向上");
    }

    void eat() {
        System.out.println(name + "今天吃啥？");
    }

    void sleep(){
        System.out.println(name + "好困啊啊啊啊啊！");
    }


}
