package com.hnu.data;

import com.hnu.bean.Admin;
import com.hnu.bean.Business;
import com.hnu.bean.Food;
import com.hnu.util.IOUtils;

import java.io.File;
import java.io.*;
import java.util.ArrayList;

/**
 * 存储我们存放数据的集合
 */
public class ElemeDB {

    public static final File BUSINESS_File = new File("business.txt");
    public static final File ADMIN_File = new File("admin.txt");
    public static final File FOOD_File = new File("food.txt");
    public static ArrayList<Business> BUSINESS_LIST;
    public static ArrayList<Admin> ADMIN_LIST;
    public static ArrayList<Food> FOOD_LIST;
    //静态块  在类加载的时候只加载一次 会自动执行 无需调用
    static {

        try {
            //初始化文件  保证文件的创建
            initFile();
            //初始化商家集合
            initBusinessList();
            //初始化管理员集合
            initAdminList();
            //初始化餐品集合
            initFoodList();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 初始化文件
     * @throws IOException
     */
    public static void initFile() throws IOException {
        if ( !BUSINESS_File.exists()){

            BUSINESS_File.createNewFile();
        }

        if ( !ADMIN_File.exists()){

            ADMIN_File.createNewFile();
        }
        if ( !FOOD_File.exists()){

            FOOD_File.createNewFile();
        }
    }

    public static void initBusinessList() throws Exception {

        if (BUSINESS_File.length()>0){
            //文件里面已经有内容了  直接读出来

            BUSINESS_LIST = (ArrayList<Business>) IOUtils.readObj(BUSINESS_File);
            return;
        }
        //文件中没有任何内容  此时我们需要新建集合
        BUSINESS_LIST = new ArrayList<>();

        //将我们新建的集合写入到文件中
        IOUtils.writeObj(BUSINESS_File,BUSINESS_LIST);


    }

    public static void initAdminList() throws Exception{

        if (ADMIN_File.length()>0){
            //文件里面已经有内容了  直接读出来

            ADMIN_LIST = (ArrayList<Admin>) IOUtils.readObj(ADMIN_File);
            return;
        }
        //文件中没有任何内容  此时我们需要新建集合
        ADMIN_LIST = new ArrayList<>();

        //对于管理员不做添加操作  在初始化时创建管理员
        ADMIN_LIST.add(new Admin(32131321,"zhangsan","123456"));
        ADMIN_LIST.add(new Admin(64732784,"admin","admin"));
        //将我们新建的集合写入到文件中
        IOUtils.writeObj(ADMIN_File,ADMIN_LIST);
    }

    /*
    初始化餐品集合
     */
    private static void initFoodList() throws Exception {

        if (FOOD_File.length()>0){
            //文件里面已经有内容了  直接读出来

            FOOD_LIST = (ArrayList<Food>) IOUtils.readObj(FOOD_File);
            return;
        }
        //文件中没有任何内容  此时我们需要新建集合
        FOOD_LIST = new ArrayList<>();

        //将我们新建的集合写入到文件中
        IOUtils.writeObj(FOOD_File,FOOD_LIST);


    }


}

    /* //初始化集合
        BUSINESS_LIST = new ArrayList<>();
        //添加默认的初始化数据  便于测试
        BUSINESS_LIST.add(new Business(32321,"111111","福建沙县小吃","经七路纬七路","干净卫生 好吃不贵",15.0,2.5));
        BUSINESS_LIST.add(new Business(32322,"111111","美味小吃","经六路纬七路","干净卫生，好吃不贵",15.0,3.8));
        BUSINESS_LIST.add(new Business(32323,"111111","福记烩面","经五路纬七路","干净卫生，好吃不贵",15.0,3.8));
        BUSINESS_LIST.add(new Business(32324,"111111","柳州螺蛳粉","经四路纬七路","干净卫生，好吃不贵",15.0,3.8));


     */
