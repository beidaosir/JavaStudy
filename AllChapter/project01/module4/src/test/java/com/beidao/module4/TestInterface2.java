package com.beidao.module4;


/**
 * 接口特性3——封装
 * @author beidao
 * 接口——面向对象的集大成者（封装、继承、多态）
 *
 */

public class TestInterface2 {

    public static void main(String[] args) {

        M m = new N();//接口类型代表了实现类对象
        m.m();//接口对象调用接口方法


    }
}


interface M{
    void m();//public abstract void m();

}
class N implements M{

    public String name;

    @Override
    public void m(){
        System.out.println("m");
    }

    public void n(){
        System.out.println("n");
    }
}


