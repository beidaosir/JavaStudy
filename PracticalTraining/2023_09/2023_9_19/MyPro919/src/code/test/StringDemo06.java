package code.test;

public class StringDemo06 {

    public static void main(String[] args) {

        /*String str = "";

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
                str+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
*/

        /*
        String是不可变的 以上的程序每次拼接都会产生一个新的字符串对象  final char[] value
        StringBuilder、StringBuffer 可变的  char[] value   效率比String要高

        StringBuffer 线程安全  多线程使用这个
        StringBuilder  线程不安全  没有多线程就使用这个  效率高
         */

        StringBuilder sb = new StringBuilder();
//        StringBuffer sb = new StringBuffer();

        /*sb.append(1).append(true).append(45.3);

        System.out.println(sb);*/

        /*
        常用方法：
           append  追加
           insert 插入
           delete 删除

         System.currentTimeMillis();   1970.1.1 00:00:00 ~ 当前时间点 之间的毫秒数
         */

       /* long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            sb.append(i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);*/

        System.out.println(System.currentTimeMillis()); //1695111414556

    }

}
