package code.practice;

public class Test13 {

    public static void main(String[] args) {
        int number = 1587; // 一个不多于5位的正整数
        int length;
        // 获取数字的位数
        if (number > 9999){
            length = 5;
        } else if (number > 999) {
            length = 4;
        } else if (number > 99) {
            length = 3;
        } else if (number > 9) {
            length = 2;
        }else
            length = 1;

        System.out.println("数字的位数：" + length);

        for (int i = 0; i < length; i++) {
            System.out.print(number % 10 + " "); // 打印每一位数字
            number /= 10; // 取出下一位数字

        }
    }
}
