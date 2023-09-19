package code.practice;

import java.util.Scanner;

/*
1．编写一个程序
实现从命令行参数输入两个字符串类型的数值
并计算输出两个数值的和。
 */
public class Test01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数值:");
        String a = scanner.nextLine();
        System.out.println("请输入第二个数值:");
        String b = scanner.nextLine();
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int sum = a1 + b1;
        System.out.println("两个数值相加的和为：" + sum);
    }

}
