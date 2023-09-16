package code.practice;

import java.util.Arrays;

public class Test21 {
    public static void main(String[] args) {

        int[] arr = {18,25,7,36,13,2,89,63};

        int[] reverseArr = new int[arr.length];

        for (int i = arr.length; i > 0; i--) {

            reverseArr[arr.length-i] = arr[i-1];
        }
        System.out.println(Arrays.toString(reverseArr));
    }
}
