package code.test;

import java.util.ArrayList;

/**
 * 集合框架重点部分：
 * 单列数据
 * Collection
 *    List
 *      ArrayList 【重点】
 *      LinkedList
 *    Set
 *      HashSet
 *      TreeSet
 *
 * 双列数据
 * Map
 *   HashMap  【重点】
 *   TreeMap
 */
public class Demo02 {

    public static void main(String[] args) {

        /**
         * ArrayList 【重点】
         *   属性
         *   构造方法
         *   方法  功能
         *
         * 作为类的使用者其实是在使用方法
         *  1、构建对象
         *  2、常用方法
         *
         *  ArrayList
         *  底层：使用Object[] elementData来装元素的  Object[] elementData = {}
         *  第一次添加值  设置为默认容量为10
         *  之后容量够就添加进去   不够了就扩容 10*1.5 = 15    15*1.5=22  .....
         *
         *  只能存对象
         */
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);  //add(Object) 可以传入int类型原因是自动装箱 int---Integer
        arrayList.add(23.4);
        arrayList.add("张三");
        arrayList.add(true);
        arrayList.add(34.5f);
        arrayList.add('g');
        arrayList.add(arrayList);

        System.out.println(arrayList.toString()); //重写了toString

        arrayList.add(1,"李四");

        System.out.println(arrayList);

        //判断是否包含某个元素
        System.out.println(arrayList.contains("张三峰"));

        //得到某个下标对应的元素
        System.out.println(arrayList.get(5));

        //是否空集合
        System.out.println(arrayList.isEmpty());

        //修改
        arrayList.set(1,"王五");

        System.out.println(arrayList);

        //通过元素获取下标
        System.out.println(arrayList.indexOf("张三"));
        //元素个数
        System.out.println(arrayList.size());
    }

}
