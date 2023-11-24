package code.test;

public class Demo02 {

    public static void main(String[] args) {
        int n = 10; // 要输出的斐波那契数列个数
        int a = 1, b = 1, c;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
    }
}