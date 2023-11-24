package code.test3;

public class Person {

    static String chaodai; //朝代   //静态成员变量   类变量
    String name; //成员变量   //实例变量

    static {
        System.out.println("这是静态块，初始化类");
    }

    {
        System.out.println("构造块，初始化对象");
    }

    public static void study(){
        System.out.println("这是一个静态成员方法");
    }

    public void eat(){
        System.out.println("这是一个普通成员方法");
    }
}
