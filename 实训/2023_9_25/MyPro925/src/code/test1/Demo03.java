package code.test1;

import java.io.*;

/**
 * 转换流
 * 如果读取文本文件
 *  可以自己构建流对象--------直接构建字符流对象
 *  如果是通过方法获取的，并且获取了一个字节流对象  -------- 转换成字符流【InputStreamReader】 ----- 转换成缓冲流 readLine
 *
 *  输出转换流
 *  OutputStream = new FileOutputStream();
 *    OutputStreamWriter
 *      BufferedWriter
 *        write
 *        newLine
 */
public class Demo03 {


    public static void main(String[] args) {

        //目标文件 读取这个文件中的内容
        File file = new File("hello.txt");

        try {
//            OutputStream outputStream = getOutputStream(file);
            //以上文本文件关联的是字节流  直接读取的话有可能出现中文乱码
            //将以上的字节流转成字符流即可
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            //字符流  --- 字符缓冲流
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(getOutputStream(file)));

            writer.write("白日依山尽，");
            writer.newLine();
            writer.write("黄河入海流，");
            writer.newLine();
            writer.write("黄河入海流，");
            writer.newLine();
            writer.write("黄河入海流。");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 得到目标文件的字节流
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static OutputStream getOutputStream(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

}