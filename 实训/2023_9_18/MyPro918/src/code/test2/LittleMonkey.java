package code.test2;

public class LittleMonkey extends OldMonkey implements Flyable,Swimable {

    @Override
    public void climbTree() {
        System.out.println(name+"刚跟着爸爸学会爬树");
    }

    @Override
    public void fly() {
        System.out.println(name+"装了可以飞行的翅膀，在空中滑翔");
    }

    @Override
    public void swim() {
        System.out.println(name+"非常好学，又学会了蛙泳");
    }
}