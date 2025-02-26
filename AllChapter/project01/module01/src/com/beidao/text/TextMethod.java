package com.beidao.text;

public class TextMethod {

    static int add(int a, int b){//形参
        return a + b;
    }

    public static void main(String[] args) {
        int add = TextMethod.add(1, 2);//实参
        System.out.println(add);
    }

}
