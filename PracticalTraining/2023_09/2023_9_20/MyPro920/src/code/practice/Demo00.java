package code.practice;

import java.util.Scanner;

public class Demo00 {

    public static void main(String[] args) {
        //分别在控制台输入字符串和子字符串，并计算字符串中子字符串出现的次数。

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个字符串：");
        String str = scanner.nextLine();
        //"helloworldhellojackhellorose"

        System.out.println("请输入第二个字符串：");
        String zi = scanner.nextLine();
        //"hello"

        int index = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            index = str.indexOf(zi, index);
            //System.out.println(index);
            if (index == -1){
                break;
            }else {
                index += zi.length();
                //System.out.println(index);
                count ++;
            }

        }
        System.out.println("次数为：" + count);

    }

}
