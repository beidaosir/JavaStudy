package com.beidao.module3;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);
        System.out.println(list.getClass());


        List<Integer> list2 = List.of(1,2,3,4,5);
        System.out.println(list2.getClass());


        System.out.println(list2);

    }
}
