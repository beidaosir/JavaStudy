package code.test;

public class StringDemo01 {

    public static void main(String[] args) {

        String s1 = "abc"; //常量池
        String s2 = "abc"; //在常量池中找到相同的直接使用

        String s3 = new String("abc"); //new一次会创建一块空间
        String s4 = new String("abc");


        /*
        以上四个是同一个对象吗？
        int i = 3   int j = 3
        i == j
        == :  针对基本类型比较  比较值
              针对引用类型对象比较   比较物理地址
         */
        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        /*
        String类型对象打印时打印的不是物理地址，而是字符串的内容，这是因为重写了父类的toString方法
        String也重写了equals
           Object本身的equals方法和==一样
           String重写之后对比的是字符串内容而不是地址

        String也重写了hashCode方法
           Object本身的hashCode方法是一个本地(native)方法  不是用Java语言实现的  返回的是数字和内存地址相关
           String重写之后根据字符串中的字符计算，所以只要字符串内容相同 hashCode值就相同
         */
        System.out.println(s1.toString());
        System.out.println(s3);

        System.out.println(s1 == s3);
        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());


//        Student student = new Student();
//        Student student1 = new Student();
//        System.out.println(student.hashCode());
//        System.out.println(student1.hashCode());
    }

}
