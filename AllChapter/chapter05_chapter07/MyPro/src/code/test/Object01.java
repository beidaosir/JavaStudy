package code.test;

public class Object01 {

    public static void main(String[] args) {

        //使用oop面向对象解决
        //实例化一只猫[创建一只猫对象]
        //1.new Cat() 创建一只猫
        //2.Cat cat1 = new Cat(); 把创建的猫赋给 cat1
        //cat1就是一个对象
        Cat cat1 = new Cat();
        cat1.name = "小白";
        cat1.age = 3;
        cat1.color = "白色";

        //创建第二只猫，并赋值给cat2
        Cat cat2 = new Cat();
        cat2.name = "小黄";
        cat2.age = 2;
        cat2.color = "黄色";

        //怎么访问对象的属性呢
        System.out.println("第一只猫信息：" + cat1.name +" " + cat1.age + "岁 " + cat1.color);
        System.out.println("第二只猫信息：" + cat2.name +" " + cat2.age + "岁 " + cat2.color);
    }
}

class Cat{
    //属性
    String name;
    int age;
    String color;
}
