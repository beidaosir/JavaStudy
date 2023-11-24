package cn.neusoft.test;
//倒三角
public class Demo05 {
    public static void main(String[] args) {
        //外层循环 层数
        for (int i = 1; i < 10; i++) {
            //内层循环
            for (int j = 1; j < 10-i+1; j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println(" ");
        }
    }
}
