package cn.neusoft.test;
/*
质数是只能被1和自身整除的自然数，
也称素数，质数中最小的为2。
所有自然数都可以被自身和1整除。
 */

public class Zhishu {
    public static void main(String[] args) {
        int n = 29;
        boolean b = true; //布尔类型，表示是否为质数，初始值为真
        for (int i = 2; i < n; i++) {
            //若能够整除则不是质数
            if (n % i == 0) {
                b = false;
                break; //跳出循环
            }
        }
        //输出结果，判断是否为质数
        if (b) {
            System.out.println(n + "是质数");
        } else {
            System.out.println(n + "不是质数");
        }
    }
}
