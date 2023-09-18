package code.test4;

public class Son extends Father{

    static String str = "子类的静态成员变量";
    String name = "子类的成员变量";

    static {
        System.out.println(str);
        System.out.println("子类的静态块");
    }

    {
        System.out.println(name);
        System.out.println("子类的构造块");
    }

    public Son(){
        System.out.println("子类的构造方法");
    }
    
}
