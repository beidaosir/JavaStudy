package code.test4;

public class Demo01 {

    public static void main(String[] args) {

        Window window = new Window();

        Thread a = new Thread(window,"窗口A");
        Thread b = new Thread(window,"窗口B");

        a.start();
        b.start();

    }
}
