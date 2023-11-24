package cn.neusoft.test;
//数组中数据的访问与赋值

public class Demo01 {
    public static void main(String[] args) {

        int[] nums = {23,56,45,12,9,78,98};
        //通过下标获取数值
        System.out.println(nums[0]);
        int a =nums[1];
        System.out.println(a);

        System.out.println("-------循环获取数组中所有的数据--------");
        //i循环的就是下标
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        //给数组中的数据重新赋值
        nums[0]=88;
        System.out.println();
        System.out.println("-----遍历数组-----");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
