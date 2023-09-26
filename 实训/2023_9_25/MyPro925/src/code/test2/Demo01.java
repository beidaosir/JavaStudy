package code.test2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 数据只能存文件
 * 餐饮管理系统
 *   Food
 *     添加
 *        1 糖醋排骨  35
 *        2 小炒肉   43
 *        3 四喜丸子   28
 *        ....
 *
 *  一行行存取数据太麻烦
 *  读写对象会比较好
 */
public class Demo01 {

    public static void main(String[] args) {
        /*
        创建一些Food对象 设置参数
        放入一个Food集合中
        将集合保存到文件中
         */
        Food food1 = new Food(1,"糖醋排骨",35.0);
        Food food2 = new Food(2,"小炒肉",24.0);
        Food food3 = new Food(3,"四喜丸子",33.5);

        ArrayList<Food> foodArrayList = new ArrayList<>();
        Collections.addAll(foodArrayList,food1,food2,food3);

        System.out.println(foodArrayList);

        //执行写操作  需要输出流(对象流)   NotSerializableException
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("对象流.txt"));
            //序列化
            objectOutputStream.writeObject(foodArrayList);

            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
