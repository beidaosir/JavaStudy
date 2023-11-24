package code.test1;

public class AnimalTest {

    public static void main(String[] args) {

        Animal animal = new Cat();
        animal.name = "tom";
        animal.showInfo();
        animal.breath();

        /*
        抽象类无法创建对象
        因为抽象类中存在抽象方法，调用该方法时没法运行
         */
//        Animal animal1 = new Animal();
//        animal1.showInfo();
    }

}
