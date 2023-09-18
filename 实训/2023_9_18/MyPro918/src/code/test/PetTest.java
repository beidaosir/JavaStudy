package code.test;

/**
 * 上溯： 父类 对象名 = new 子类();
 * 下溯： 子类 对象名 = (子类)父类对象;
 *       确定能转成子类类型才转 否则会报错 ClassCastException
 *       if(对象 instanceof 类型){
 *           强转
 *       }
 * 1、能不能调用看声明的类型
 * 2、new的是谁就执行谁的
 */
public class PetTest {

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.nickName = "小雪";
        cat.age = 2;
        cat.brand = "橘猫";

        Pet pet = cat; //类型上溯   子类对象赋值给父类引用   父类声明接收子类对象

        /*
        能保证pet是Cat类型才强转
         */
        Cat c = (Cat) pet;  //类型下溯   强转

        /*
        在强转中可能发生的问题
        ClassCastException
         */
        pet = new Dog();
        pet.nickName = "旺柴";
        pet.age = 2;
        pet.brand = "中华田园犬";
//        Cat cc = (Cat) p1;

        // instanceof  这个关键字可以帮助判断一个对象是否为某个类型
        // 对象 instanceof 类型

        System.out.println(pet instanceof Dog);

        if (pet instanceof Dog){
            Dog d = (Dog) pet;
            d.shout();
        }else if(pet instanceof Cat){
            Cat ccc = (Cat) pet;
            ccc.shout();

        }
    }

}
