package cn.neusoft.test;

import java.util.Arrays;

/*
选择排序
 */
public class Demo08 {


    public static void main(String[] args) {

        int[] numbers = {45,32,67,99,8,12,9,44};

        //数组中的最大值和最小值
        int max = numbers[0];
        int maxIndex = 0;
        int temp = 0;//交换空间

        //外层循环负责排序的次数
        for (int j = 1; j < numbers.length; j++) {
            //重新初始化最大值  否则最大值还是上次找到的
            max = numbers[0];
            maxIndex = 0;

            //内层循环负责每次找到最大值跟后面的位置交换
            for (int i = 1; i < numbers.length-j+1; i++) {
                //前面的值大才会去交换
                if (numbers[i] > max)
                {
                    max = numbers[i];
                    maxIndex = i;
                }

            }
            //将最大值和最后一个值交换
            temp = numbers[maxIndex];
            numbers[maxIndex] = numbers[numbers.length-j];
            numbers[numbers.length-j] = temp;


            System.out.println(Arrays.toString(numbers));

        }

    }
}
