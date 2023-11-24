package code.practice;

public class Test04 {

    public static void main(String[] args) {

        int i = 0,total = 0;
        do{
            i = i + 2;
            System.out.println("i=" + i);
            total = total + (i++) * 2;
        }while(i < 12);
        System.out.println("总数为：" + total);
    }
}
