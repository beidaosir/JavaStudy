package code.test3;

/*
static：静态
  修饰成员变量  称之为类变量  只要类加载就会加载  在内存中只有一份
  可以通过类名直接调用

  任何对象对静态成员变量的修改都会引起值的变化


  修饰成员方法
     静态方法可以通过类名直接调用
     非静态的方法需要通过该类的对象调用

  全局常量一般定义方式：
   public static final 类型 常量名 = 值;
   类名.常量名    例如： Math.PI

  静态块

 */
public class PersonTest {

    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name = "张三丰";
        Person.chaodai = "明朝";

        Person p2 = new Person();
        p2.name = "李斯";
        Person.chaodai = "秦朝";

        System.out.println(p1.name+"   "+Person.chaodai);
        System.out.println(p2.name+"   "+Person.chaodai);

        p1.eat();
        p2.eat();
        Person.study();

        /*
        调用实例变量，需要通过对象名调用
        调用类变量，只需要通过类名调用   Person.chaodai
         */

    }

}