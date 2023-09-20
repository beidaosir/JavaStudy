package code.test;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo03 {

    public static void main(String[] args) {
        /*
         * ArrayList的遍历
         */
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);  //add(Object) 可以传入int类型原因是自动装箱 int---Integer
        arrayList.add(23.4);
        arrayList.add("张三");
        arrayList.add(true);
        arrayList.add(34.5f);
        arrayList.add('g');

        System.out.println("****************普通for循环遍历******************");
        for (int i = 0; i < arrayList.size(); i++) {
            Object o = arrayList.get(i);
            System.out.println(o);
        }

        System.out.println("***************foreach循环*******************");
        for(Object o:arrayList){
            System.out.println(o);
        }

        System.out.println("**************迭代遍历********************");
        //获取迭代器
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }

    }

}