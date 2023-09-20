package cn.neusoft.test1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Demo01 {

    public static void main(String[] args) {
        //1．编写一个程序，实现从命令行参数输入两个字符串类型的数值，并计算输出两个数值的和。

        Scanner sr = new Scanner(System.in);

        System.out.println("请输入一个数字：");

        String num1 = sr.nextLine();

        System.out.println("请在输入一个数字：");
        String num2 = sr.nextLine();

        //转数字
        double v1 = Double.parseDouble(num1);
        double v2 = Double.parseDouble(num2);

        double he = v1+v2;

        String formatHe = new DecimalFormat("0.00").format(he);

        System.out.println(v1+"+"+v2+"="+formatHe); //数字格式化    DecimalFormat
    }

}
