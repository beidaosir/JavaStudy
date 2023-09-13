package cn.neusoft.test;

public class Demo05 {

    public static void main(String[] args) {

        //声明一个String数组并赋值
        String[] names = {"张三", "李四", "王五", "赵六", "韩梅梅"};

        String newName = "张三丰";

        //指定插入位置
        int index = 2;

        //创建一个新数组
        String[] newNames = new String[names.length + 1];

        //将老数组的值复制到新数组  将下标2空出来
        for (int i = 0; i < names.length; i++) {
            //names[i]
            if (i<index){
                newNames[i] = names[i];
            }else if (i>=index){
                newNames[i+1] = names[i];
            }
        }
        //要插入的值放入新数组即可
        newNames[index] = newName;

        //遍历新数组
        for (int i = 0; i < newNames.length; i++) {
            System.out.print(newNames[i] + " ");
        }
    }
}
