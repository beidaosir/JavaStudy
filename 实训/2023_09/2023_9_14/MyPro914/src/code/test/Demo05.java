package code.test;
/*
方法重载：
    在同一个类中，功能类似的方法可以同名
    但是参数列表必须不同
 */

public class Demo05 {
    public static void main(String[] args) {
        System.out.println(sum(3,5));
        System.out.println(sum(3.1f,5.5f));

    }

    /*
    求和
     */
    public static int sum(int a, int b){
        return a+b;
    }

    public static float sum(float a, float b){
        return a+b;
    }

    public static int sum(int a, int b, int c){
        return a+b+c;
    }




}
