package cn.neusoft.test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo08 {

    public static void main(String[] args) {
        /*
        编写一个方法验证用户输入的日期格式是否正确，要求格式为：2006/12/12。
        方法的参数是要验证的日期字符串，如果格式正确返回true，否则返回false。
         */
        String dateStr = "2006-12-12";
        System.out.println(checkDate(dateStr));
    }

    public static boolean checkDate(String dateStr){

        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            simpleDateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            //e.printStackTrace(); //打印异常栈信息
            System.out.println("日期格式不正确，应该是：2023/09/20");
        }

        return false;
    }
}
