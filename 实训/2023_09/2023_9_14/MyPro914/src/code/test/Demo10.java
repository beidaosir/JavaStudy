package code.test;

/*
编写一个方法abs( )，既可以对整数进行绝对值获取，
又可以对小数进行绝对值的获取

重载
 */
public class Demo10 {

    public static void main(String[] args) {

        int num1 = -5;
        double num2 = -2.3;

        System.out.println(num1 + "的绝对值是"+ " = " + abs(num1));
        System.out.println(num2 + "的绝对值是"+ " = " + abs(num2));

    }

    public static int abs(int num) {
        return num >= 0 ? num : -num;
    }

    public static double abs(double num) {
        return num >= 0.0 ? num : -num;
    }
}







