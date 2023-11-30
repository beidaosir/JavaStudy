package code.test;
/*
编写一个方法，输出大于200的最小的质数。
 */

public class Demo08 {

    public static void main(String[] args) {
        getZhi();

    }

    public static void getZhi() {

        //从200开始循环，找到就结束循环
        for (int i = 200; i < 1000; i++) {

            //假设是质数
            boolean isZhi = true;
            //判断每一个i是否为质数
            for (int j = 2; j < i; j++) {
                //存在可以整除的就不是质数
                if (i % j == 0) {
                    isZhi = false;
                    break;
                }

            }
            //如果当前的i是质数，就可以跳出循环了,因为没有被整除
            if (isZhi) {
                System.out.println(i + "是200之后的最小质数");
                break;
            }
        }
    }
}
