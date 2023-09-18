package code.test1;

/**
 * 抽象类中可以存在抽象方法    接口中也可以存在抽象方法
 * 也可以有普通方法
 */
public abstract class Animal {

    String name;
    int age;

    Animal(){
        System.out.println("Animal的空构造方法");
    }

    /**
     * 如果类在描述对象时存在不能具体实现的方法可以用抽象修饰符abstract修饰
     * 抽象方法可以没有方法体
     */
    public abstract void showInfo();

    public void breath(){
        System.out.println(name+"会呼吸");
    }

}
