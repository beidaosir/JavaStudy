package code.test;

import java.io.*;

public class CopyDemo01 {

    public static void main(String[] args) {

        /*
        需求：利用前面学到的字符流的知识完成一个文件的复制
         1、定义一个目标文件
         2、确定要复制到那个路径下
         */

        String fromPath = "D:\\02CS\\java_code\\PracticalTraining\\复盘\\md文件\\JavaSE基础语法2班.md";
        String toPath = "D:\\桌面文件\\随写\\abc";

        //1、构建文件对象
        File fromFile = new File(fromPath);
        if (!fromFile.exists()){
            System.out.println("您要复制的文件不存在，程序结束");
            return;
        }

        //2、构建要复制到的路径对象
        File toFileDir = new File(toPath);
        if (!toFileDir.exists()){
            toFileDir.mkdirs();
        }
        //使用父路径+自己的文件名构建toFile
        File toFile = new File(toFileDir,fromFile.getName());


        //3、使用from文件构建输入流    使用to文件构建输出流
        Reader reader = null;
        Writer writer = null;
        try {

            reader = new FileReader(fromFile);
            writer = new FileWriter(toFile);

            //从输入流中读取   写到输出流
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer))>0){
                //将每次读到缓冲区的内容写到to文件    注意：只写读到长度的字符
                writer.write(buffer,0,len);
                writer.flush();
            }

            System.out.println("复制文件成功！！！");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (writer!=null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}