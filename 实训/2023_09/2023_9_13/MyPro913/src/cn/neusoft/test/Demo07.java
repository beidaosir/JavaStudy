package cn.neusoft.test;

public class Demo07 {

    public static void main(String[] args) {

        int[] numbers = {45,32,67,99,8,12,9,44};

        //数组中的最大值和最小值
        int max = numbers[0];
        int min = numbers[0];

        //负责将每轮比较之后最大值放在最后
        for (int i = 1; i < numbers.length-1; i++) {
            //前面的值大才会去交换
            if (numbers[i] > max)
            {
                int temp = numbers[i];
                numbers[i] = numbers[i+1];
                max = temp;
            }else if (numbers[i] < min)
            {
                int temp = numbers[i];
                numbers[i] = numbers[i+1];
                min = temp;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }
}
