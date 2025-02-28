package com.beidao.module3;
/*
 * @author beidao
 *
 */
public class TestArray {
    public static void main(String[] args) {

        //1.
        String[] a = new String[2];
        a[0] = "hello";
        a[1] = "world";

        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a.length);

        System.out.println("=======================");

        //2.
        String [] c = {"hello","world"};
        System.out.println(c[0]);
        System.out.println(c[1]);
        System.out.println(c.length);
        System.out.println("=======================");


        //3.
        String [] d ={"hello","world"};
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }

        int[] b = new int[2];
        b[0] = 1;
        b[1] = 2;

        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b.length);



    }
}
