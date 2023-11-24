package code.test1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * OutputStream  字节输出流
 *    FileOutputStream  关联一个文件做写操作
 *      write(int)
 *      write(byte[])   “你好哈哈”.getBytes()
 *
 *  字符流写完必须flush
 *  字节流可以不用flush
 */
public class OutputDemo01 {

    public static void main(String[] args) {

        try {
            //1、创建字节输出流
            OutputStream outputStream = new FileOutputStream("字节流.txt");
            //2、写操作
            outputStream.write(97);
            outputStream.write(65);
            outputStream.write(48);
            // 字节流执行写操作   只能写数字或者字节数组【字符串可以转成字节数组】
            byte[] bytes = "a你b好".getBytes();
            System.out.println(Arrays.toString(bytes));
            outputStream.write(bytes);

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}