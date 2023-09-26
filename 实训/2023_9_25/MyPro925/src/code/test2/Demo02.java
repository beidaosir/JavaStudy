package code.test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * 读取对象
 *   1、第一次进入系统  文件可能还没有创建？
 *   2、新建的文件是没有内容的，没有内容的时候怎么办
 *   3、初始化内容  创建集合  给集合中添加Food数据  把初始化的数据存储下来
 *   4、接下来就可以读取了
 *
 * 假设不是第一次进来
 *   文件中已经有对象了  可以直接读出来
 */
public class Demo02 {

    public static void main(String[] args) {

        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream("对象流.txt"));
            //反序列化
            ArrayList<Food> foodArrayList = (ArrayList<Food>)objectInputStream.readObject();
            System.out.println("编号\t菜名\t\t价格");
            for (Food food: foodArrayList) {
                System.out.println(food.getNumber()+"\t"+food.getName()+"\t"+food.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
