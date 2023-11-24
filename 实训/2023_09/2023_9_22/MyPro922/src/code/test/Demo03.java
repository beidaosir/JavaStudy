package code.test;

import java.io.File;

public class Demo03 {

    public static void main(String[] args) {

        File dir = new File("D:\\桌面文件\\随写\\acd");
        printFile(dir,0);
    }

    public static void printFile(File target,int kong){
        //在文件名前面打印缩进的-，表示层级
        for (int i = 0; i < kong; i++) {
            System.out.print("-");
        }
        //打印文件的名字
        System.out.println(target.getName());

        //判断是不是一个文件  是就可以结束了
        if (target.isFile()){
            return;
        }

        //是文件夹  获取所有的子文件列表
        File[] files = target.listFiles();

        //文件名前面的缩进-数量增加
        kong+=2;

        //遍历子文件
        for (File child:files) {

            //对所有子文件执行相同的操作
            printFile(child,kong);
        }

    }


}