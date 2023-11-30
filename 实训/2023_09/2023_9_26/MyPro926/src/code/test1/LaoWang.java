package code.test1;

public class LaoWang {

    public static void main(String[] args) {

        System.out.println("老王开始做家务了");

        //创建线程类对象
        Cooker cooker = new Cooker();

        //创建Runnable 的实现类对象 但是没有start方法无法启动
        Washer washer = new Washer();

        //创建Thread线程对象并将任务对象washer设置给它
        Thread washerThread = new Thread(washer);

        //原神启动
        cooker.start();
        washerThread.start();

        System.out.println("老王终于做完家务了可以刷抖音了！");
        for (int i = 0; i < 100; i++) {
            System.out.println("老王在刷抖音，在打赏主播 一笑倾城" + i);
        }

    }
}
