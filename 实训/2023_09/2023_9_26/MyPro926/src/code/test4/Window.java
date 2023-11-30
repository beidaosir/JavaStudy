package code.test4;

/**
 * 模拟火车站窗口卖票
 */
public class Window implements Runnable{

    int ticketsNumber = 1000;
    Object lock = new Object();  //保证唯一

    @Override
    public void run() {

        while (true){
            //同步代码块
            synchronized (lock){
                if (ticketsNumber < 1) {
                    break;
                }

                try {
                    Thread.sleep(100);  //释放cpu  不释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "卖出一张票，余票为" + (--ticketsNumber));
            }

        }

    }
}