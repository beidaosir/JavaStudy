package com.beidao.module4;

/**
 * 接口特性-多态
 * @author beidao
 *
 * 方法多态的两个条件：
 * 1.用父类型代表子类型,或者用接口类型来代表实现类对象
 * 2.子类重写了父类的方法————方法重写
 *
 */

public class TestInterface1 {

    public static void main(String[] args) {

        E[] array = new E[]{
                new F(),
                new G()
        };


        for (int i = 0; i < array.length; i++) {
            E e = array[i];
            e.e();//方法多态
            //接口对象重写之后的内容
        }
    }

}

interface E{

  /*  //默认方法     更多用的是抽象方法
    default void e(){
        System.out.println("E");
    }
*/
    //抽象方法 只有抽象方法声明，没有方法体
    //只能是public的，public abstract也可省略
    //为什么抽象方法设计为不需要方法体
    //实现类，必须重写接口的抽象方法
    public abstract void e();

}

class F implements E{

    @Override
    public void e() {
        System.out.println("F");
    }

}

class G implements E{

    @Override
    public void e() {
        System.out.println("G");
    }
}


