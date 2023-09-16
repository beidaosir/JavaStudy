package code.practice;

public class Test15 {
    public static void main(String[] args) {
        int i;
        int sum = 0;
        for (i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
        }
        System.out.println("for循环结果：" + sum);

        sum = 0;
        i = 1;
        while (i <= 100) {
            if (i % 3 == 0) {
                sum += i;
            }
            i++;
        }
        System.out.println("while循环结果：" + sum);

        sum = 0;
        i = 1;
        do {
            if (i % 3 == 0) {
                sum += i;
            }
            i++;
        } while (i <= 100);
        System.out.println("do循环结果：" + sum);
    }
}