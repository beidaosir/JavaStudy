package cn.neusoft.test;

public class Demo04 {
    public static void main(String[] args) {
        //外层循环打印层数，每一层结束换行
        for (int i = 0; i < 4; i++) {
            //负责打印空格
            for (int k = 0; k < 4-i-1 ; k++) {
                System.out.print(" ");
            }
            //内层循环负责打印每一层的*
            for (int j = 0; j < 2*i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();//换行
        }
    }
}
