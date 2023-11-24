package code.practice;
/*
编写一个简单程序，要求数组长度为5，分别赋值10，20，30，40，50，在控制台输出该数组的值。
 */
public class Test17 {

    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
