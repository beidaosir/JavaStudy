package code.practice;

public class Demo01 {

    public static void main(String args[]) {
        String s1 = new String("Hello!");
        String s2 = new String("I love JAVA.");
        A s = new A(s1, s2);
        System.out.println(s1 + s2);
        System.out.println(s.toString());
    }
}


class A {
    String s1;
    String s2;

    A(String str1, String str2) {
        s1 = str1;
        s2 = str2;
        str1 = "No pain ,";
        str2 = "no gain!";
        System.out.println(str1 + str2);
    }

    public String toString() {
        return s1 + s2;
    }
}