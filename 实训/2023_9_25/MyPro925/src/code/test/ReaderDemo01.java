package code.test;

import java.io.*;

public class ReaderDemo01 {

    public static void main(String[] args) {

        File file = new File("abc.txt");
        if (!file.exists()){
            System.out.println("您要读取的目标文件不存在");
            return;
        }

        //因为在finally块中要关闭reader，所以要声明再外面  而且要赋初值
        Reader reader = null;
        //1、创建字符输入流对象
        try {
            reader = new FileReader(file);

            /*//循环读取字符
            while (true){
                //读取单个字符
                int i = reader.read();
                //判断是否到达文件末尾
                if (i == -1){
                    break;
                }
                //打印字符
                System.out.println((char)i);
            }*/

            /******************优化********************/
        /*    int i;
            while ((i = reader.read()) > -1){
                System.out.print((char)i);
            }*/

            //创建一个char数组作为缓冲区来使用
            char[] buffer = new char[1024];

            //声明每次读到的字符长度
            int len;

            //每读一次就更新长度的值  并且判断读到的长度是否大于0
            while ((len = reader.read(buffer)) > 0){
                //使用每次读到的字符串创建字符串  需要使用长度来构建
                System.out.println(new String(buffer,0,len));
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //reader的创建本身有可能报错  所以对象可能创建不出来  关闭之前判断一下是否为空
            if (reader!=null){
                try {
                    //关闭reader  关闭本身也可能发生IO异常  所以要通过try catch处理
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}