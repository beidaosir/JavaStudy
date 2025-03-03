package com.beidao.module3;

import java.util.ArrayList;

public class TestGeneric {

    public static void main(String[] args) {

        // 创建一个ArrayList对象，并指定泛型为Interger
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 添加元素
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int sum=0;
        // 遍历
        for (Integer i : list) {

            sum+=i;
            System.out.println(i);
        }

        System.out.println("sum="+sum);

    }
}
