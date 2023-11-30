package cn.neusoft.test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
1、字符串和Date之间的转换
2、Date和Calendar之间的转换   setTime(Date)   getTime()
3、Calendar的add方法的使用
 */
public class Demo03 {

    public static void main(String[] args) throws ParseException {
        //巴黎时间比北京时间晚7个小时，纽约时间比北京时间晚12个小时，
        // 试编写一程序，根据输入的北京时间输出相应的巴黎和纽约时间。

        String beijingDateStr = "2022-12-23 12:00:00";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beijingDate = simpleDateFormat.parse(beijingDateStr);

        //Calendar  add(小时,7/12)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beijingDate);
        calendar.add(Calendar.HOUR_OF_DAY,7);

        Date baliDate = calendar.getTime();
        System.out.println("巴黎时间："+baliDate);

        //计算纽约时间  重新给Calendar设置一下北京时间
        calendar.setTime(beijingDate);
        calendar.add(Calendar.HOUR_OF_DAY,12);

        Date newYorkDate = calendar.getTime();
        System.out.println("纽约时间："+newYorkDate);

    }

}
