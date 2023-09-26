package com.hnu.data;

import com.hnu.bean.Business;

import java.util.ArrayList;

/**
 * 存储我们存放数据的集合
 */
public class ElemeDB {

    public static ArrayList<Business> BUSINESS_LIST;
    //静态块  在类加载的时候只加载一次
    static {

        //初始化集合
        BUSINESS_LIST = new ArrayList<>();
        //添加默认的初始化数据  便于测试
        BUSINESS_LIST.add(new Business(32321,"111111","福建沙县小吃","经七路纬七路","干净卫生 好吃不贵",15.0,2.5));
        BUSINESS_LIST.add(new Business(32322,"111111","美味小吃","经六路纬七路","干净卫生，好吃不贵",15.0,3.8));
        BUSINESS_LIST.add(new Business(32323,"111111","福记烩面","经五路纬七路","干净卫生，好吃不贵",15.0,3.8));
        BUSINESS_LIST.add(new Business(32324,"111111","柳州螺蛳粉","经四路纬七路","干净卫生，好吃不贵",15.0,3.8));

    }
}
