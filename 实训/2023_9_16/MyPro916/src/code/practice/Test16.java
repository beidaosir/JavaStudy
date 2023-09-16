package code.practice;
/*
定义一个任意的4位整数，求将该数反转以后的数，如原数为1234，反转后的数位4321。
 */
public class Test16 {

    public static void main(String[] args) {
        int number = 1234; // 定义一个任意的4位整数
        int reverse;

        reverse = (number%10)*1000+(number/10%10)*100+(number/100%10)*10+number/1000;

        System.out.println("原数：" + number);
        System.out.println("反转后的数：" + reverse);
    }
}
