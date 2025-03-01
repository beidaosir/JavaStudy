package com.beidao.module4;

/**
 * @author beidao
 * 同一个文件只能有一个public类
 * 接口-解决单继承的问题
 * 1.需要放入接口的方法必须加default关键字（默认方法）
 * 2.default方法只能是public或者protected
 */
public class TestInterface {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.swim();
        duck.fly();
    }
}


interface Swimable {
	default void swim(){
        System.out.println("swim");
    }
}


interface Flyable {
	default void fly(){
        System.out.println("fly");
    }
}

class Duck implements Swimable, Flyable {


}