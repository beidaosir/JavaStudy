package code.test3;

import java.util.HashMap;

public class Demo02 {

    public static void main(String[] args) {
        HashMap<Integer,Student> map = new HashMap<>();
        map.put(1001,new Student("张三",20));
        map.put(1002,new Student("Jack",21));
        map.put(1003,new Student("Tom",22));
        map.put(1004,new Student("Rose",23));
        map.put(1005,new Student("张三",20));

        System.out.println(map);

        System.out.println();


        HashMap<Student,Integer> map2 = new HashMap<>();
        map2.put(new Student("张三",20),1001);
        map2.put(new Student("Jack",21),1002);
        map2.put(new Student("Tom",22),1003);
        map2.put(new Student("Rose",23),1004);
        map2.put(new Student("张三",20),1005);

        System.out.println(map2);
        System.out.println();

    }

}
