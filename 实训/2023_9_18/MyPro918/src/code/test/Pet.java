package code.test;

public class Pet {

    String nickName;//昵称
    int age; //年龄
    String brand; //品种

    public Pet(){
        System.out.println("Pet的空构造");
    }

    void showInfo(){
        System.out.println("我是一只"+age+"岁的"+brand+",我的名字是"+nickName);
    }

    void shout(){
        System.out.println(nickName+"在叫");
    }

}



class Cat extends Pet{

    Cat(){
        System.out.println("Cat的空构造");
    }

    @Override
    public void shout() {
        System.out.println(nickName+"猫在喵喵叫");
    }

    void catchMouse(){
        System.out.println(nickName+"猫喜欢玩猫鼠游戏");
    }

}



class Dog extends Pet{

    @Override
    void shout() {
        System.out.println(nickName+"狗狗汪汪叫");
    }

    void watchDoor(){
        System.out.println(nickName+"会看大门");
    }

}




