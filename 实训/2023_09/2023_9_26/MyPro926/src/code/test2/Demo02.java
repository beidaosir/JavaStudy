package code.test2;

/**
 * 通过匿名内部类创建线程对象
 */
public class Demo02 {

    public static void main(String[] args) {

        /**
         * 匿名： 没有名字  只能使用一次
         * 内部类：  包裹一个类中的类  或者  包裹在一个方法中的类就叫内部类
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"*********"+i);
                }
            }
        });
        thread.start();


        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"-----------"+i);
                }
            }
        };
        thread1.start();


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"-----------"+i);
                }
            }
        }.start();

    }

}
