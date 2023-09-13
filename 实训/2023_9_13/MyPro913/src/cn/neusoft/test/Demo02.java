package cn.neusoft.test;

/*
  需求：
  数组中存储了班级的学生姓名
  有新的同学转学过来了需要加入该数组
 */
public class Demo02 {
    public static void main(String[] args) {

        String[] names = {"张三","李四","Tom","Mike","Siri","王五"};

        //声明一个新学生姓名
        String newName = "Jam";

        /*
        数组的空间一旦开辟无法修改长度，
        只能开辟新空间才能放下更多数据
        */
        //计算新长度
        int newLength = names.length + 1;

        //创建一个具有新长度的数组
        String[] newNames = new String[newLength];


        //将原来的数组中的学生复制过来
        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }

        //将新学生放在新数组的最后一个位置
        newNames[newNames.length - 1] = newName;


        //遍历新数组
        for (int i = 0; i < newNames.length; i++) {
            System.out.print(newNames[i] + " ");
        }
    }

}
