package cn.neusoft.test;

//冒泡排序

import java.util.Arrays;

public class Demo06 {

    public static void main(String[] args) {
        /*
        通过多次排序完成
        第一次：两两相比，大的值往后换，第一次结束，最大的值会在最后一个
         */
        int[] numbers = {45,32,67,99,8,12,9,44};

/*

        //第一趟
        for (int i = 0; i < numbers.length-1; i++) {
            //前面的值大才会去交换
            if (numbers[i] > numbers[i+1])
            {
                int temp = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = temp;
            }
        }
*/

        //外层循环负责比较七次
        for (int j = 1; j < numbers.length; j++) {

            //负责将每轮比较之后最大值放在最后
            for (int i = 0; i < numbers.length-j; i++) {
                //前面的值大才会去交换
                if (numbers[i] > numbers[i+1])
                {
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                }
            }
            //通过api来输出数组的元素值
            System.out.println(Arrays.toString(numbers));
        }

    }
}
