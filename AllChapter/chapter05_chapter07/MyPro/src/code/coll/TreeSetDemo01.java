package code.coll;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Consumer;

public class TreeSetDemo01 {

    public static void main(String[] args) {

        //1.创建TreeSet集合对象
        TreeSet<Integer> ts = new TreeSet<>();

        //2.添加元素
        ts.add(1);
        ts.add(3);
        ts.add(5);
        ts.add(2);
        ts.add(4);

        //3.打印集合
        System.out.println(ts);

        //4.遍历集合
        //迭代器
        /*Iterator<Integer> iterator = ts.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        //增强for
     /*   for (Integer i:
             ts) {
            System.out.println(i);
        }*/

        //lambda
        ts.forEach(i-> System.out.println(i));

    }
}
