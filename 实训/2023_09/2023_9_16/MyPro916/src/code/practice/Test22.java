package code.practice;

import java.util.Arrays;

/*
将一个数组中的重复元素保留一个其他的清零。
 */
public class Test22 {

    public static void main(String[] args) {
        int[] arr = {18, 25, 7, 36, 13, 2, 89, 63, 2, 7, 13};
        int[] result = new int[arr.length];
        int j = 0;
        //第一个for循环遍历原数组
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            //第二个for循环遍历已经存储在结果数组中的元素
            for (int k = 0; k < j; k++) {
                if (arr[i] == result[k]) {
                    //如果当前元素与结果数组中的某个元素相等，
                    //则说明该元素是重复的，将isDuplicate标记为true，并跳出循环
                    isDuplicate = true;
                    break;
                }
            }
            //如果当前元素不是重复的，则将其存储在结果数组中，
            // 并将j加1。最终，结果数组中存储的就是去重后的元素。
            if (!isDuplicate) {
                result[j++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
