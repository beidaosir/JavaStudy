package code.test;

import java.util.Arrays;

/*
 写一个方法，功能：定义一个一维的int 数组，长度任意,
 然后将它们按从小到大的顺序输出（使用冒泡排序
 */
public class Demo09 {

    public static void main(String[] args) {

        int[] numbers = {45,2,32,102,67,99,12,9,3,77,1};

        bubbleSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    public static void bubbleSort(int[] numbers){
        
        //外层循环负责比较
        for (int i = 1; i < numbers.length; i++) {
            
            //负责每次比较之后将最大的值放在最后面
            for (int j = 0; j < numbers.length-i; j++) {
                //前面的值大才交换
                if (numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
                
            }
        }

    }

}
