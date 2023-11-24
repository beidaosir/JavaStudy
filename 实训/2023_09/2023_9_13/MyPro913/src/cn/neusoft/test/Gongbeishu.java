package cn.neusoft.test;

public class Gongbeishu {

    public static void main(String[] args) {
        int a = 8,b = 12;
        int i;
        for (i = 1; i <a*b ; i++) {
            if (i%a==0 && i%b==0)
                break;
        }
        System.out.println(i);
    }
}
