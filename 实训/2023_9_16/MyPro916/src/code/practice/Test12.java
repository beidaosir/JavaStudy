package code.practice;

public class Test12 {

    public static void main(String[] args) {
        int x = 5; // 三个任意整数
        int y = 2;
        int z = 8;

        if (x < y && x < z) {
            System.out.println(x + " " + y + " " + z);
        } else if (y < x && y < z) {
            System.out.println(y + " " + x + " " + z);
        } else {
            System.out.println(z + " " + x + " " + y);
        }
    }
}
