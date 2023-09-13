package cn.neusoft.test;
/*
  需求：
  数组中存储了班级的学生姓名
  有一个同学要转走

  构建一个新数组
 */
public class Demo03 {
    public static void main(String[] args) {

        //声明一个String数组并且赋值
        String[] names = {"张三","李四","Tom","Mike","Siri","王五"};

        String name = "Tom";

        //创建一个新的数组  新的长度比之前小1
        String[] newNames = new String[names.length-1];

        /*
        循环遍历names  对比出目标值
        目标值后面的值往新数组中复制时需要前移一个下标
        新数组[i] = 老数组[i]
        碰到目标值之后
        新数组[i] = 老数组[i+1]
        注意：字符串对比的时候  .equals()
            System.out.println("Tom".equals("李四") =>  false
         */
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if(name.equals(names[i])){
                index = i;
                break;
            }


        }
        //System.out.println(index);

        if(index != -1) {
            for (int i = 0; i < names.length; i++) {

                //如果i小于index
                if (i < index) {
                    newNames[i] = names[i];
                } else if (i > index) {
                    newNames[i - 1] = names[i];
                }
            }
            //遍历新数组
            for (int i = 0; i < newNames.length; i++) {
                System.out.print(newNames[i] + " ");
            }
        }else{
            System.out.println("要删除的同学不在");

        }


    }
}
