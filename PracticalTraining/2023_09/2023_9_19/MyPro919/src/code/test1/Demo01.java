package code.test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01 {

    public static void main(String[] args) throws ParseException {

        //对象的创建
        Date date = new Date();
        System.out.println(date);

        /*
        转换日期的输出格式  2023-9-19 ...
        需要使用一个日期格式化类
        DateFormat  SimpleDateFormat
        将一个日期对象转成一个格式化字符串

        SimpleDateFormat
        "yyyy-MM-dd HH:mm:ss"  可以取其中一部分
        format(Date) ----> String
         */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);
        System.out.println(dateStr);

        /*
         ""2023-09-11 17:17:56"
         将一个日期字符串转成日期对象

         SimpleDateFormat
         "yyyy-MM-dd HH:mm:ss"   "2022-08-20 17:16:45"  格式一致
         parse(String)  ----> Date   处理异常[因为传入的字符串很有可能不是日期类型 也有可能和pattern不匹配]
         */

        String myDate = "2023-09-11 17:17:56";
        Date  mDate = format.parse(myDate);
        System.out.println(mDate);

    }

}
