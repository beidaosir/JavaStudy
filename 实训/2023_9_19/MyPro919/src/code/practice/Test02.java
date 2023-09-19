package code.practice;

import java.util.Scanner;

/*
分别在控制台输入字符串和子字符串
并计算字符串中子字符串出现的次数。
 */
public class Test02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String str = scanner.nextLine();
        System.out.print("请输入子字符串：");
        String subStr = scanner.nextLine();

        //记录找到的索引
        int i = 0;
        int count = 0;//计数
        while (true){
            if (str.indexOf(subStr, i) == -1){
                //找不到
                break;
            }else {
                count ++;
                //更新查找索引值，继续找
                i = str.indexOf(subStr,i)+1;
            }
        }
        System.out.println(subStr+"在"+str+"中出现的次数:"+count);



    }
}
