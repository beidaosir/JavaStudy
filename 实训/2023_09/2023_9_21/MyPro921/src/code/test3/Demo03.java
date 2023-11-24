package code.test3;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Demo03 {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1001, "张三");
        map.put(1002, "李四");
        map.put(1003, "王五");
        map.put(1004, "赵六");

        //1001
//        map.get(1001);

        /*
        map不能遍历
          没有下标  也不能迭代  因为没有实现Iterable接口
          1、map转成set keySet
          2、拿到value的集合  values
          3、将map中
         */
        /*Set<Integer> keySet = map.keySet();
        for (Integer key:keySet) {
            String value = map.get(key);
            System.out.println(key+" "+value);
        }*/


        System.out.println("************迭代***************");
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            String value = map.get(key);
            System.out.println(key + "   " + value);
        }

        //只能拿到value 拿不到key
        Collection<String> values = map.values();
        for (String v : values) {
            System.out.println(v);
        }

     /*   for (String value : map.values()) {
            System.out.println(value);
        }
*/
        /*
        通过entrySet方式
         */
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet){
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);

        }


        Set<Map.Entry<Integer,String>> entrySet1 = map.entrySet();
        Iterator<Map.Entry<Integer,String>> entryIterator = entrySet1.iterator();;
        while (entryIterator.hasNext()){
            Map.Entry<Integer,String> entry = entryIterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + "————" + value);

        }


    }

}