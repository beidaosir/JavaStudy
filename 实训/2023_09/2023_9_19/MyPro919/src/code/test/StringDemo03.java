package code.test;

import java.util.Arrays;

/**
String本质上就是一个字符数组
 和字符数组可以互相转换
 toCharArray   new String(char[] arr]
 和字节数组可以互相转换
  getBytes   new String
 */
public class StringDemo03 {

    public static void main(String[] args) {

        //字符串  ----》  字符数组
        String a = "hdsajkj";
        char[] arr = a.toCharArray();

        System.out.println(Arrays.toString(arr));//打印出来的是数组中的字符
        System.out.println(arr); //打印出来直接就是字符数组的内容   hdsajkj    特别！！！！

        int[] nums = {1,2,3,4,5};
        System.out.println(nums); //打印出来 [I@776ec8df


        //字符数组 -----》 字符串
        char[] ccc = {'n','i','u'};
        String str = new String(ccc);
        System.out.println(str);



        //字符串 ----》 字符数组

    }

}