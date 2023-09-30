package com.hnu.util;

import com.hnu.bean.Business;

import java.io.*;
import java.util.ArrayList;

public class IOUtils {

    /*
    往指定文件中写入一个对象
    file 指定文件
    obj 写入的对象
     */
    public static void writeObj(File file,Object obj) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
    }

    /*
   往指定文件中写入一个对象
   file 指定文件
   obj 读到的对象
    */
    public static Object readObj(File file) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        return objectInputStream.readObject();


    }
}
