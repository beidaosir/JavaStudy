package code.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo01 {

    public static void main(String[] args) {

        Writer writer = null;//声明输出流  为什么要赋为null？


        try {
            //创建字符输出流对象  并给writer赋值
            writer = new FileWriter("abc.txt");

            //执行写入操作
            writer.write("this is a 写入操作！");

            //写入之后刷新一下
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

            //关闭流  为什么要做这个判断，这是什么意思？
            if (writer != null){

                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
    }
    }
}
