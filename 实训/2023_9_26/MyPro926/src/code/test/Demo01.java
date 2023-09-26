package code.test;

public class Demo01 {

    public static void main(String[] args) {

        System.out.println("这是主线程");

        System.out.println("开启MyThread线程");
        //创建线程对象
        MyThread myThread = new MyThread();
        //启动线程
        myThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main--------------------"+i);
        }

    }

}

/*
线程类
1、方式一：继承Thread类
         重写run方法【线程的任务】
         在其他线程中(主线程)中创建线程类对象   并启动
 */
class MyThread extends Thread{

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread----------"+i);
        }

    }
}