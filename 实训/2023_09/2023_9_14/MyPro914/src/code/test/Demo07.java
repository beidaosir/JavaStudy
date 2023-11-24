package code.test;

/*
判断平年还是闰年
 */
public class Demo07 {

    public static void main(String[] args) {

        year(2000);
        year(1900);
    }

    public static void year(int y){
        if((y % 4 == 0 && y % 100 != 0) || (y % 400 ==0)){
            System.out.println(y + "是闰年");
        }else {
            System.out.println(y + "是平年");
        }
    }

}
