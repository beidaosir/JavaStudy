
package code.test5;


import java.util.ArrayList;
import java.util.Collection;

public class Demo01 {

    public static void main(String[] args) {

//        printAllParam(2,3,4,5,"kkkk");

        ArrayList<String> arrayList = new ArrayList();
        addAll(arrayList,"张三","lll","abc");
        System.out.println(arrayList);
    }

    /*
     自定义 一个方法   传递不定项参数【本质上是数组】  将这些参数打印出来
     在方法上声明泛型
     */
    public static <T> void printAllParam(T...params){
        for (int i = 0; i < params.length; i++) {
            System.out.println(params[i]);
        }
    }

    /*
    传递进来的不定项参数中的每一个值放入到Collection集合中
    方法上声明的泛型只有在这个方法中才能使用
    参数列表  方法体  返回值
     */
    public static <W> void addAll(Collection<W> collection, W...params){
        for (int i = 0; i < params.length; i++) {
            collection.add(params[i]);
        }
    }

}