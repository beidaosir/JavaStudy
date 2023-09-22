package code.test;

import java.io.File;

public class Demo01 {

    public static void main(String[] args) {
          /*
        File  文件类
           可以关联文件 和 文件夹
         */

        File file = new File("D:\\02CS\\java_code\\PracticalTraining\\Project\\2023_9_22\\test01.txt");
        System.out.println("是否文件夹:" + file.isDirectory());
        System.out.println("是否文件:" + file.isFile());
        System.out.println("绝对路径:" + file.getAbsolutePath());
        System.out.println("路径:" + file.getPath());
        System.out.println("长度:" + file.length());
        System.out.println("文件名:" + file.getName());

    }
}
