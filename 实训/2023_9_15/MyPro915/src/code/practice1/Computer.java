package code.practice1;

/*
5.定义一个笔记本类，该类有颜色（char）和cpu型号（int）两个属性。
(1)无参和有参的两个构造方法；有参构造方法可以在创建对象的同时为每个属性赋值；
(2) 输出笔记本信息的方法
然后编写一个测试类，测试笔记本类的各个方法。
 */
public class Computer {

    char color;
    int cpu;

    Computer(){

    }

    Computer(char color,int cpu){
        this.color = color;
        this.cpu = cpu;

    }

    void printInfo(){
        System.out.println("颜色：" + color + "  型号：" + cpu);
    }
}
