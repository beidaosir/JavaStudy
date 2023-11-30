package code.practice;

import java.util.Arrays;

/*
在一个有8个整数（18，25，7，36，13，2，89，63）的数组中找出其中最大的数及其下标。
 */
public class Test20 {

    public static void main(String[] args) {
        int[] arr = {18,25,7,36,13,2,89,63};
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }

        }
        System.out.println("最大值：" + max + "  下标为：" + maxIndex);
        
    }
}
