package code.practice;

/*
给定一个成绩a，使用switch结构求出a的等级。
A：90-100，B：80-89，C：70-79，D：60-69，E：0~59
 */
public class Test06 {

    public static void main(String[] args) {

        int a = 77;

        switch (a/10) {

            case 10:

            case 9:

                System.out.println("A");

                break;

            case 8:

                System.out.println("B");

                break;

            case 7:

                System.out.println("C");

                break;

            case 6:

                System.out.println("D");

                break;

            default:

                System.out.println("E");

                break;

        }
    }

}
