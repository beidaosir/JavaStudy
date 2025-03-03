package com.beidao.module3;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心类库——Map
 * @author beidao
 * 键值对 key ——> value      key要唯一
 * 映射关系
 *两个泛型分别用来限制键 值类型
 * Map的增删改查
 *
 */
public class TestMap {


    public  static String find3(String key){
       /*
       // of()方法创建一个不可变的Map
       Map<String, String> map = Map.of(
                "bright", "小明",
                "white", "小白",
                "black", "小黑"
        );
        */

        //可变的Map集合——HashMap()
        Map<String,String> map = new HashMap<>();
        map.put("bright","小明");
        map.put("white","小白");
        map.put("black","小黑");


        map.put("bright","小明ming");//覆盖
        map.remove("bright");//删除

        map.entrySet();//获取所有键值对集合

        // 遍历集合  for(临时变量的类型 Map.Entry<K,V> : 要遍历的集合)
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"-->"+entry.getValue());
        }


        return map.get(key);
    }

    public static void main(String[] args) {
        System.out.println(find3("bright"));
        System.out.println(find3("black"));
    }




}
