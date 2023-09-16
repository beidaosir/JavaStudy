package code.practice;
/*
声明一个0～100的成绩变量，如果不是0～100之间，打印成绩无效，
根据成绩等级（等级自己划分）打印A,B,C,D,E
 */
public class Test11 {

    public static void main(String[] args) {

        int score = 70;
        if (score>=90 && score <= 100){
            System.out.println("A");
        } else if (score>=80 && score <90) {
            System.out.println("B");
        } else if (score>=70 && score <80) {
            System.out.println("B");
        } else if (score>=60 && score <70) {
            System.out.println("B");
        }else {
            System.out.println("打印成绩无效");
        }
    }
}
