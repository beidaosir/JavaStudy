package code.test;

/**
 * String类用final修饰了  不能被继承
 *     这个字符数组就是String用来存储字符的
 *     private final char value[];   不可以重写赋值
 *
 * String是不可变的
 */
public class StringDemo02 {

    public static void main(String[] args) {
        String a = "abc";
        String b = "ABC";

        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b)); //忽略大小写

        System.out.println("aa".compareTo("aa")); //比较字典顺序  想通返回0

        System.out.println("罗刹海市.mp3".endsWith(".mp4"));
    }

}
