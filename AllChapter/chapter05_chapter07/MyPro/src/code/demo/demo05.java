package code.demo;

public class demo05 {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();

            }

        };
        System.out.print("ping");
        //t.start();

    }
    static void pong() {
        System.out.print("pong");
    }

}
