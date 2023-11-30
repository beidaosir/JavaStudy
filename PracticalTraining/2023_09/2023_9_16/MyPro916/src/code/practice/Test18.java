package code.practice;

import java.util.Arrays;

/*
将一个字符数组的值（neusofteducation）拷贝到另一个字符数组中。
 */
public class Test18 {

    public static void main(String[] args) {

        char[] arr = {'n','e','u','s','o','f','t','e','d','u','c','a','t','i','o','n'};
        char[] copyArr = new char[arr.length];//定义目标数组

        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];

        }
        System.out.println(Arrays.toString(copyArr));
    }
}
