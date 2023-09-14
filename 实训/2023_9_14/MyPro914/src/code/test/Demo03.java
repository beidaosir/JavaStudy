package code.test;

public class Demo03 {

    public static void main(String[] args) {

        printTriangle(7);

    }

    /*
    打印三角形的方法
    声明参数列表，调用时必须传入对应类型和个数的参数
     */

    public static void printTriangle(int ceng) {
        for (int row = 1; row <= ceng; row++) { // 外层循环执行换行
            // 打印空格的数量为层数减去所在行数
            for (int c1 = 0; c1 < ceng - row; c1++) {
                System.out.print(' ');
            }
            // 打印星号的数量为所在行数的2倍减1
            for (int c2 = 0; c2 < 2 * row - 1; c2++) {
                System.out.print('*');
            }
            // 换行
            System.out.println();
        }
    }


}

