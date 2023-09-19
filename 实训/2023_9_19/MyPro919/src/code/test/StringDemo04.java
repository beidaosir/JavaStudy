package code.test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo04 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        /*
        GBK    两个字节表示一个汉字
        UTF-8    三个字节表示一个汉字
         */
        //编码
//        byte[] gbks = "好".getBytes("GBK"); // [-70, -61]
        byte[] gbks = "你好".getBytes("UTF-8"); //[-27, -91, -67]
        System.out.println(Arrays.toString(gbks));

        //解码
        String str = new String(gbks,"GBK");
        System.out.println(str);
    }

}
