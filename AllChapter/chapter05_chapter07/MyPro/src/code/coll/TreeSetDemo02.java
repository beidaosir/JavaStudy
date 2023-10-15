package code.coll;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo02 {

    public static void main(String[] args) {
        /*
        需求:请自行选择比较器排序和自然排序两种方式;
        要求:存入四个字符串，“c”，“ab”，“df”，“gwer”按照长度排序，
        如果一样长则按照首字母排序

        如果使用第一种排序方式输出结果为  [ab, c, df, qwer]  不满足需求

        所以选择第二种排序方式：比较器排序

         */

        //1.创建TreeSet集合对象
        //o1：表示当前要添加的元素
        //o2：表示已经在红黑树存在的元素
        //返回值规则跟之前是一样的
/*        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按照长度排序
                int i = o1.length() -o2.length();
                //长度一样按照首字母排序
                i = i == 0?o1.compareTo(o2):i;
                return i;//[c, ab, df, qwer]
            }
        });*/

        //lambda表达式
        TreeSet<String> ts = new TreeSet<>((o1,o2)-> {
                //按照长度排序
                int i = o1.length() -o2.length();
                //长度一样按照首字母排序
                i = i == 0?o1.compareTo(o2):i;
                return i;//[c, ab, df, qwer]
        });

        //2.添加元素
        ts.add("c");
        ts.add("ab");
        ts.add("df");
        ts.add("qwer");

        //3.打印集合
        System.out.println(ts);

        //


    }
}
