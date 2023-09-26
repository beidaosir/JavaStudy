package code.test1;

import java.io.*;

/**
 * 字节流读取文本文件存在中文字节拆分的问题
 * 不会使用字节流去读取文本文件
 *
 * 读取文本文件：字节流转换成字符流
 *
 * 其他文件，比如音频、视频、图片一般不会来读取里面的字节，一般都是复制
 * 可以使用字节流复制各种文件
 * 先读后写
 *
 * 文件复制： 字符流只能复制文本文件   字节流可以复制所有文件
 *
 * 字节流也有缓冲流
 *   BufferedInputStream
 *   BufferedOutputStream
 */
public class InputDemo02 {

    public static void main(String[] args) {

        String fromPath = "D:\\ev录频\\录频\\test1.mp4";
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

        try {
            //从from文件中读取
            InputStream inputStream = new FileInputStream(fromFile);
            //写到to文件中
            OutputStream outputStream = new FileOutputStream(toFile);
            /*int read;
            while ((read = inputStream.read()) != -1){
                System.out.println(read);
            }*/
            /*
            无论字节数组定多大，都有可能在边界处将汉字拆分
             */
            /*byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer))>0){
                System.out.println(new String(buffer,0,len));
            }*/

            /*
            可以使用字节流复制各种文件
            先读后写
             */
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer))>0){
                outputStream.write(buffer,0,len);
                System.out.println("------------");
            }

            System.out.println("复制完成！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}