package code.test6;

/**
 * 模拟火车站窗口卖票
 */
public class Window extends Thread{

    static int ticketsNumber = 1000;

    @Override
    public void run() {

        while (ticketsNumber > 0){
            maipiao();
        }

    }

    /*
    静态同步方法，锁是Window.class   字节码文件对象
     */
    public static synchronized void maipiao(){
        if (ticketsNumber > 0) {
            try {
                Thread.sleep(10);  //释放cpu  不释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖出一张票，余票为" + (--ticketsNumber));
        }

    }
}