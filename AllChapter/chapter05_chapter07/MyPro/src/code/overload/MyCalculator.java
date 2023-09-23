package code.overload;

public class MyCalculator {

    public static void main(String[] args) {

        System.out.println(calculate(5.1, 2));
    }


    //下面的四个 calculate方法构成了重载
    // 两个整数的和
    public static int calculate(int n1, int n2){
        System.out.println("calculate(int n1, int n2) 被调用");
        return n1 + n2;
    }

    public static double calculate(double n1, int n2){
        System.out.println("calculate(double n1, int n2) 被调用");
        return n1 + n2;
    }

    public static double calculate(int n1, double n2){
        System.out.println("calculate(int n1, double n2) 被调用");
        return n1 + n2;
    }

    public static double calculate(double n1, double n2){
        System.out.println("calculate(double n1, double n2) 被调用");
        return n1 + n2;
    }

}
