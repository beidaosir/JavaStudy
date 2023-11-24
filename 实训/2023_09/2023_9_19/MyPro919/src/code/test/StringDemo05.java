package code.test;


public class StringDemo05 {

    public static void main(String[] args) {

        String names = "张三,李四,jack,tom,王五";

        String[] nameArr = names.split(",");

        for (int i = 0; i < nameArr.length; i++) {
            System.out.print(nameArr[i] + " ");
        }
        System.out.println();

        String replace = "helloh".replace('h', 'H');
        System.out.println(replace);

        String s = "hellohello".replaceAll("l", "L");
        System.out.println(s);

        String s1 = "hellohello".replaceFirst("h", "H");
        System.out.println(s1);

        System.out.println('e');//用下标找字符
        System.out.println("hellohello".indexOf("ll"));//用字符串或者字符找对应下标

        System.out.println("hello".toUpperCase());
        System.out.println("ABCDEFG".toLowerCase());

        System.out.println("hello".charAt(1));  //用下标找字符
        System.out.println("hellohello".indexOf("ll")); //找字符串或字符对应的下标  从前往后找
        System.out.println("hello".indexOf('l'));
        System.out.println("hello".lastIndexOf("l")); //从后往前找

        System.out.println("helloworld".substring(5)); //截取字符串
        System.out.println("helloworldjack".substring(5, 10));

        //      张三          张三      去空格   只能去左右   中间去不掉
        System.out.println("   张三    ".length());
        System.out.println("   张   三    ".trim().length());

        System.out.println("abc".concat("def"));  // 拼接字符串 "abc"+"def"



    }

}
