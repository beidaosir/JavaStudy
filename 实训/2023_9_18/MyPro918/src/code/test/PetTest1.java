package code.test;

/**

 */
public class PetTest1 {

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.nickName = "小雪";
        cat.age = 2;
        cat.brand = "橘猫";

        cat.shout();
        cat.showInfo();
        cat.catchMouse();

        /*
        父类声明接收子类对象
        调用属性和方法时只能调用父类存在的

        1、能不能调用看声明的类型

        子类重写父类的方法之后，父类声明接收子类对象，调用该方法，执行的是子类方法

        2、new的是谁就执行谁的
         */
        Pet pet = cat;
        pet.shout();
//        pet.catchMouse();



    }

}
