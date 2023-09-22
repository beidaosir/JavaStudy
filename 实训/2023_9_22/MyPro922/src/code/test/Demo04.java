package code.test;

import java.io.File;

public class Demo04 {

    public static void main(String[] args) {

        /*
        删除文件
          1、非空文件夹删不掉
          2、空文件夹可以删
          3、文件可以删
         */
        File file = new File("D:\\桌面文件\\随写\\acd");
//        boolean delete = file.delete();
//        System.out.println(delete);

        deleteFile(file);
    }

    /**
     * 删除文件
     * @param target  目标文件
     */
    public static void deleteFile(File target){


        if (target.isDirectory()){

            File[] children = target.listFiles();
            for (File child:children) {
                deleteFile(child);
            }
        }

        boolean delete = target.delete();
        System.out.println("删除"+target.getName()+  " " +delete);

    }


}