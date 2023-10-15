package code.demo;

public class demo06 {
    public static void main(String args[]) {
        String x = "fmn";
        x.toUpperCase();
        System.out.println(x);
        String y = x.replace('f','F');
        System.out.println(y);
        System.out.println(x);
        y = y + "wxy";
        System.out.println(y);
    }

}
