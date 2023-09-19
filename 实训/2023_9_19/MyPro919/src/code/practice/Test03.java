package code.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
输入一个时间字符串"xxxx-xx-xx" 显示出对应的XXXX年XX月XX日
 */
public class Test03 {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个时间字符串:");
        String timeStr = scanner.nextLine();

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(timeStr);
        String now = new SimpleDateFormat("yyyy年MM月dd日").format(date);
        System.out.println(now);

    }

}