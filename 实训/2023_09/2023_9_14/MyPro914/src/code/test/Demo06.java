package code.test;

/*
求阶乘
 */
public class Demo06 {

    public static void main(String[] args) {

        jie(5);
    }


    public static void jie(int a){
        int jie = 1;
        for (int i = 1; i <= a ; i++) {
            jie *= i;
        }
        System.out.println(jie);
    }


}
