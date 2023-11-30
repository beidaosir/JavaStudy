package code.test1;

public class Washer implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("洗衣机在洗衣服！" + i);
        }
    }
}
