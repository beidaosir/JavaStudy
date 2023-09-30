package com.hnu.util;

import java.util.Random;
/**
 * 工具类
 * 封装一些可以复用的工具方法
 */
public class ElemeUtil {

    public static int createId(){
        Random random = new Random();
        return Math.abs(random.nextInt());
    }
}
