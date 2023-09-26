package code.test5;

/**
 * 模拟火车站窗口卖票
 */
public class Window implements Runnable{

    int ticketsNumber = 1000;

    @Override
    public void run() {

        while (ticketsNumber > 0){
            maipiao();
        }

    }

    /*
    同步方法  看不到锁  其实是有的   this
    只有在实现Runnable接口的时候才能用  因为Runnable接口对象是唯一的  this唯一的
     */
    public synchronized void maipiao(){
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
