package code.practice;

/*
判断一个数字是否能被5和6同时整除（打印能被5和6整除）
或只能被5整除（打印能被5整除）
或只能被6整除（打印能被6整除）
不能被5或6整除（打印不能被5或6整除）
 */
public class Test10 {

    public static void main(String[] args) {

        int val = 36;
        if (val % 5 == 0 && val % 6 == 0) {
            System.out.println("输入的数字" + val + "能被5和6整除");
        } else if (val % 5 == 0) {
            System.out.println("输入的数字" + val + "能被5整除");
        } else if (val % 6 == 0) {
            System.out.println("输入的数字" + val + "能被6整除");
        } else {
            System.out.println("输入的数字不能被5或者6整除");
        }
    }

}
