package code.practice;

import java.util.Arrays;

/*
给定一个有9个整数（1,6,2,3,9,4,5,7,8）的数组，先排序，然后输出排序后的数组的值。
 */
public class Test19 {

    public static void main(String[] args) {

        int[] arr = {1,6,2,3,9,4,5,7,8};

        //排序
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length-i-1; j++) {

                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
