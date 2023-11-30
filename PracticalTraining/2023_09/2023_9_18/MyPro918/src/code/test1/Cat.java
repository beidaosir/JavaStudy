package code.test1;

public class Cat extends CatKindAnimal{

    Cat(){
        System.out.println("Cat的空构造方法");
    }

    @Override
    public void showInfo() {
        System.out.println("我叫"+name+"，我是一只猫咪");
    }

}