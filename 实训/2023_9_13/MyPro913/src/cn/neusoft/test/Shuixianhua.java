package cn.neusoft.test;

/*
问题描述：水仙花数指一个特殊的三位数，它的各位数字的立方和与其自身相等。请输出所有的水仙花数。
编程思路：关键是将三位数的个位、十位和百位数字分别拆分出来。
 */

public class Shuixianhua {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) { // 循环所有三位数
            int a = i % 10; // 拆分出个位数字
            int b = (i / 10) % 10; // 拆分出十位数字
            int c = i / 100; // 拆分出百位数字
            // 判断立方和是否等于自身
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println(i);
            }
        }

    }
}
