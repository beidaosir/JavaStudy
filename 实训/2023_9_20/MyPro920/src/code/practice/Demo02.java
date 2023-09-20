package cn.neusoft.test1;

public class Demo02 {

    public static void main(String[] args) {
//        编写一个程序，实现从命令行参数输入一字符串，统计该字符串中字符“e”出现的次数。

        String str = "dsaeekhjkehkjehjkeehjkhjkee";

        int number = 0;  //e的数量
        // 字符串长度    可以通过下标拿到对应位置的字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'e'){
                //e的数量自增
                number++;
            }
        }

        System.out.println("e出现的次数为："+number);
    }

}
