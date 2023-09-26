package code.test1;

public class Cooker extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("电饭煲在做饭！" + i);
        }
    }
}
