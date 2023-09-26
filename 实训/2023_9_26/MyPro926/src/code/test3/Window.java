package code.test3;

/**
 * 模拟火车站窗口卖票
 */
public class Window extends Thread{

    static int ticketsNumber = 1000;  //静态
    static Object lock = new Object();  //保证唯一

    @Override
    public void run() {

        while (true){
            //同步代码块
            synchronized (lock){
                if (ticketsNumber < 1) {
                    break;
                }

                try {
                    Thread.sleep(10);  //释放cpu  不释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "卖出一张票，余票为" + (--ticketsNumber));
            }

        }

    }
}