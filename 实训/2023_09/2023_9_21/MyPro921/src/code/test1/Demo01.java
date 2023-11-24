package code.test1;

import java.util.Collections;
import java.util.TreeSet;

public class Demo01 {

    public static void main(String[] args) {

        /**
         * 1、底层 ：二叉树结构   红黑树  自旋转  尽量会达到一个平衡的状态  一个节点有两个子节点
         * 2、排序  有一个根元素root  小的值放左边  大的放右边
         * 3、对于数字按照从小到大排序  字符串会根据字典顺序排序
         * 4、不能存储相同的元素   认定重复  通过compareTo比较返回0
         * 5、不能存储null值
         */
        TreeSet treeSet = new TreeSet();
        treeSet.add(11);
        treeSet.add(2);
        treeSet.add(6);
        treeSet.add(9);
        treeSet.add(5);
//        treeSet.add(null);

        System.out.println(treeSet);

        treeSet.clear();

        System.out.println(treeSet);

        Collections.addAll(treeSet,"white","apple","pear","jack","abc");

        System.out.println(treeSet);

        //字符串  字典顺序比较的方法 compareTo

        TreeSet<Student> stuTree = new TreeSet<>();
        Student s1 = new Student("Mike",25);
        Student s2 = new Student("Jack",22);
        Student s3 = new Student("Tom",21);
        Student s4 = new Student("Rose",23);
        Student s5 = new Student("Beidao",20);
        Collections.addAll(stuTree,s1,s2,s3,s4,s5);

        System.out.println(stuTree);


    }

}
