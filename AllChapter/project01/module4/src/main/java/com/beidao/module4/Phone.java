package com.beidao.module4;

public class Phone {

    //类型 名字
    String brand; // 品牌
    String memory; // 内存
    String size; // 尺寸
    String color; // 颜色
    double price; // 价格

    //构造方法是创建对象的时候调用的方法  作用：初始化对象
    //构造方法没有返回值，没有返回类型，名字与类名相同
    /*
    格式:
    方法名(参数){
    }
     */


    Phone(String brand, String memory, String size, String color, double price) {
        this.brand = brand;
        this.memory = memory;
        this.size = size;
        this.color = color;
        this.price = price;
        this.available = true;
    }

    boolean available;
}
