package cn.neusoft.test;

import java.util.Arrays;

/*
数组查找数据
二分查找 前提是顺序排列
 */
public class Demo09 {

    public static void main(String[] args) {

        int[] numbers = {45,32,2,102,67,99,8,12,9,44,1};

        int target =9;
        int targetIndex = -1;

        //排序
        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        //二分查找

        int low = 0;
        int high = numbers.length-1;

        while (high>=low){
            //计算中位数下标
            int mid = (high+low)/2;

            if (numbers[mid] == target){
                targetIndex = mid;
                break;
            } else if (numbers[mid]>target) {
                high = mid - 1;
            } else if (numbers[mid]<target) {
                low = mid + 1;
            }

        }
        System.out.println(targetIndex);
    }
}
