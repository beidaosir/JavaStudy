package code.test3;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Demo01 {

    public static void main(String[] args) {
        /*
        Collection接口
            存储单列数据
        Map接口
            存储双列数据

        Collection和Collections有什么区别？
         */
//        HashSet set = new HashSet();
        //key 钥匙  键   value 值    键值对  key value对
        /*
        key不能重复  value可以重复
         */
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1001, "张三");
        map.put(1002, "李四");
        map.put(1003, "王五");
        map.put(1004, "赵六");
        map.put(1005, "张三");

        System.out.println(map);

        //通过key来取value
        String name = map.get(1003);
        System.out.println("1003对应的value为：" + name);

        System.out.println(map.isEmpty());

        //通过键删除
        String remove = map.remove(1003);
        System.out.println("移除的内容为：" + remove);

        System.out.println(map);

        //通过键和值删除  如果值不正确也删不掉
        boolean isRemove = map.remove(1004, "赵六六");
        System.out.println(isRemove);

        System.out.println(map);

        //获取键值对的数量
        int size = map.size();
        System.out.println("键值对的数量为：" + size);

        System.out.println(map.containsKey(1003));
        System.out.println(map.containsValue("赵六"));


    }

}
