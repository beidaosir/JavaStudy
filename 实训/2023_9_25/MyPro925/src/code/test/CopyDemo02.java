package code.test;

import java.io.*;

/*
字符缓冲流
  BufferedReader
  BufferedWriter
 */
public class CopyDemo02 {

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
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {

            /*reader = new FileReader(fromFile);
            writer = new FileWriter(toFile);*/

            reader = new BufferedReader(new FileReader(fromFile));
            writer = new BufferedWriter(new FileWriter(toFile));

            String str;
            long start = System.currentTimeMillis();
            while ((str = reader.readLine()) != null){
                writer.write(str);
                writer.newLine();
            }
            long end = System.currentTimeMillis();

            System.out.println("缓冲流复制文件成功！！！"+(end-start));

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
