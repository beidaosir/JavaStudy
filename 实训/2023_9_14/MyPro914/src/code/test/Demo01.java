package code.test;

import java.util.Arrays;

/*
斐波那契数列：
1  1  2  3  5  8  13  21  34...
 */
public class Demo01 {

    public static void main(String[] args) {


        int[] nums = new int[10];

        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i < nums.length; i++) {
                nums[i] = nums[i-1]+nums[i-2];

        }
        System.out.println(Arrays.toString(nums));


    }
}
