package com.beidao.module3;

import java.util.ArrayList;

public class TestArrayList {

    public static void main(String[] args) {

        ArrayList list = new ArrayList(5); //创建一个集合 集合初始化大小为5
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        //内部封装了扩容的机制

        list.add("f");

        System.out.println(list);

        for(Object i:list){
            System.out.println(i);
        }


    }
}
