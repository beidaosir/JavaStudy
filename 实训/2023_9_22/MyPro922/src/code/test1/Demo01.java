package code.test1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo01 {

    public static void main(String[] args) {
        //声明输出流
        Writer writer = null;

        try {
            //创建字符输出流对象  并给writer赋值
            writer = new FileWriter("D:\\桌面文件\\随写\\英语.md");

            //执行写入操作
            writer.write('h'+"\n");
            writer.write("welcome to henan normal university!"+"\n");
            writer.write("这是一个写入操作测试！");

            //刷新流
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

            //关闭流
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }



    }
}
