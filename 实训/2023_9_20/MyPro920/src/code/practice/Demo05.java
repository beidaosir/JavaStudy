package cn.neusoft.test1;

public class Demo05 {

    public static void main(String[] args) {
        //分别在控制台输入字符串和子字符串，并计算字符串中子字符串出现的次数。

        String str = "helloworldhellojackhellorose";
        String zi = "hello";

        int number = 0; //出现的次数
        int fromIndex = 0; //开始查找的下标

        while (true){

            System.out.println("从"+fromIndex+"开始找");

            //index是查找得到的下标
            int index = str.indexOf(zi, fromIndex);
            //判断该下标如果为-1  结束循环
            if(index==-1){
                break;
            }
            System.out.println("找到的下标为："+index);
            //找到了  数量自增
            number++;
            fromIndex = index + zi.length();

        }
        System.out.println(zi+"在"+str+"中出现的次数为："+number);

//        int index = str.indexOf(zi, 0);
//        System.out.println(index);
//
//        index += zi.length();
//        System.out.println(index);
//
//        index = str.indexOf(zi, index);
//        System.out.println(index);
//
//        index += zi.length();
//        System.out.println(index);
//
//        index = str.indexOf(zi, index);
//        System.out.println(index);
//
//        index += zi.length();
//        System.out.println(index);
//
//        index = str.indexOf(zi, index);
//        System.out.println(index);


    }

}
