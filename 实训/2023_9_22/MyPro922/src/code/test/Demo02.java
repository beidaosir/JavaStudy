package code.test;

import java.io.File;
import java.io.IOException;

public class Demo02 {

    public static void main(String[] args) {


        //1.判断文件的父文件夹是否存在  不存在需要创建
        //获取父文件夹
        File newFile = new File("D:\\桌面文件\\随写\\英语.md");
        File parentFile = newFile.getParentFile();
        System.out.println(parentFile);
        System.out.println(parentFile.exists());

        //2.如果不存在
        if (!parentFile.exists()){
            //3.创建文件夹
            boolean mkdir = parentFile.mkdir();
            //mkdir创建单层文件夹  mkdirs创建多层文件夹
            System.out.println("父文件夹创建："+ mkdir);
        }

        System.out.println(newFile.exists());
        try {
            boolean isCreate = newFile.createNewFile();
            System.out.println(isCreate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
