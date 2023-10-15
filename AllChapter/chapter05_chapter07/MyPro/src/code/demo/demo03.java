package code.demo;

import java.util.Arrays;

public class demo03 {

    public static void main(String[] args) {
/*
        String names[] = new String[3];
        names[2] = "li";
        names[0] = "zhang";
        names[1] = "wang";*/

        String[] names = {"zhang","wang","li"};

        //String[3] names = {"zhang","wang","li"};错误

        System.out.println(Arrays.toString(names));

    }

}
