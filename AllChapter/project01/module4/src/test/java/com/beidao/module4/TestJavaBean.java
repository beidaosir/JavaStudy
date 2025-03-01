package com.beidao.module4;


import java.io.Serializable;

/**
 * JavaBean规范
 * @author beidao
 * 1.字段私有化
 * 2.提供getter和setter方法
 * 3.提供无参构造方法
 * 4.提供有参构造方法
 * 5.提供toString方法
 * 6.提供equals方法
 * 7.提供hashCode方法
 * 8.最好实现Serializable接口
 */

public class TestJavaBean {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("beidao", true);
        System.out.println(teacher.getName());
        System.out.println(teacher.isMarried());


        teacher.setMarried(false);
        System.out.println(teacher.isMarried());
    }

}


class Teacher implements Serializable {
    private String name;
    private boolean married;
    private int age;


    public boolean isMarried() {
        //对于boolean类型的字段，get方法一般以is开头，而其他的字段一般以get开头
        return this.married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }


    //get方法 用来获取私有字段的值
    public String getName(){
        return this.name;
    }

    //set方法 用来设置私有字段的值
    public void setName(String name){
        this.name = name;
    }

    //有参构造方法
    public Teacher(String name, boolean married) {
        this.name = name;
        this.married = married;
    }

    //无参构造方法
    public Teacher() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}












