package cn.neusoft.test;
/*
  需求：
  数组中存储了班级的学生姓名
  有一个同学要转走

  在原来数组上进行覆盖
 */
public class Demo04 {

    public static void main(String[] args) {

        //声明一个String数组并赋值
        String[] names = {"张三","李四","王五","赵六","韩梅梅"};

        String name = "王五";

        //创建一个新的数组  新的长度(比之前小1)
//        String[] newNames = new String[names.length-1];
        /*
        循环遍历names  对比谁是目标值  在目标值之后的值往新数组中复制时需要前移一个下标
        新数组[i] = 老数组[i]
        碰到目标值之后
        新数组[i] = 老数组[i+1]
        注意：字符串对比的时候   .equals()
            System.out.println("王五".equals("赵六"));
         */
        //先找王五的下标
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if(name.equals(names[i])){
                index = i;
                break;
            }
        }

        if (index!=-1){


            for (int i = 0; i < names.length; i++) {

                //如果i大于index，后面内容把前面覆盖
                if(i>index){
                    names[i-1] = names[i];
                }

            }

            //覆盖之后，数组最后一个置空
            names[names.length-1] = null;

            //复制完成之后打印新数组   names.length-1是新长度
            for (int i = 0; i < names.length-1; i++) {
                System.out.println(names[i]);
            }


        }else{
            System.out.println("要删除的同学不存在");
        }

    }

}
