package code.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test05 {
    public static void main(String[] args) {
        String timeStr = "2022-05-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(timeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String formattedDate = sdf.format(date);
        System.out.println(formattedDate);
    }
}