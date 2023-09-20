package cn.neusoft.test1;

public class Demo07 {

    public static void main(String[] args) {
       // 8．有一种数叫回文数，正读和反读都一样，如12321便是一个回文数。
        // 编写一个程序，从命令行得到一个整数，判断该数是不是回文数。

        String str = "123321";

        //将字符串倒过来
        //先将str转成StringBuilder
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb);

        sb.reverse(); //逆序的方法

        //sb反转之后不需要接收返回值 它本身已经逆序了
        String reverseStr = sb.toString();

        System.out.println(str.equals(reverseStr));


    }
}
