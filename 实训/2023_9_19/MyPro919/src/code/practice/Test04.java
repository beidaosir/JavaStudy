package code.practice;

import java.util.Scanner;

public class Test04 {

    public static void main(String[] args) {
        StrCount();


    }
    private static void StrCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s = sc.nextLine();
        System.out.println("请输入子字符串：");
        String c = sc.nextLine();
        String str2 = "";
        int sum = 0;
//不明所以
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == c.charAt(0)){
                for(int j = i;j<c.length();j++){
                    str2 = str2 + s.charAt(j);
                }
                sum++;
                i=i+str2.length()-1;
            }
        }
        System.out.println("字符串"+s+"中有"+sum+"个"+c+"");
    }


}

