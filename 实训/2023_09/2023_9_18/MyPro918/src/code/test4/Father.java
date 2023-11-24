package code.test4;

public class Father {

    static String str = "父类的静态成员变量";
    String name = "父类的成员变量";

    static {
        System.out.println(str);
        System.out.println("父类的静态块");
    }

    {
        System.out.println(name);
        System.out.println("父类的构造块");
    }

    public Father(){
        System.out.println("父类的构造方法");
    }

}
