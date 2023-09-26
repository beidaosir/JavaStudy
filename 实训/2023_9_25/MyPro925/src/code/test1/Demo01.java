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
public class Demo01 {


    public static void main(String[] args) {

        //目标文件 读取这个文件中的内容
        File file = new File("F:\\河南师范大学-Java课程\\2023-09-11-JavaSE-基础语法\\code\\Hello.txt");

        try {
            InputStream inputStream = getInputStream(file);
            //以上文本文件关联的是字节流  直接读取的话有可能出现中文乱码
            //将以上的字节流转成字符流即可
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //字符流  --- 字符缓冲流    readLine
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String str;
            while ((str = reader.readLine())!=null){
                System.out.println(str);
            }

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
    public static InputStream getInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

}
