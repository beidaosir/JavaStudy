package code.coll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {

        /*
        定义一个集合 添加数据 1,2,3,4,5,6,7,8,9,10
        过滤奇数  留下偶数
        将结果保存
         */

        //1.定义集合
        ArrayList<Integer> list = new ArrayList<>();


        //2.添加数据
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);

        //3.过滤
        //进行判断 偶数-返回true-保留
        List<Integer> list1 = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        //4.打印
        System.out.println(list1);


    }
}
