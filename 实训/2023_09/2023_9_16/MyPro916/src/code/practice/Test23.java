package code.practice;
/*
给定一维数组{ -10，2，3，246，-100，0，5} ，计算出数组中的平均值、最大值、最小值。
 */
public class Test23 {

    public static void main(String[] args) {
        int sum = 0;
        int[] arr = {-10,2,3,246,-100,0,5};

        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("平均值：" + (double)sum/arr.length +"  最大值："+ arr[arr.length-1] +"  最小值：" + arr[0]);
    }
}
