package code.intel;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) throws UnknownHostException {

        //1.获取InetAddress的对象
        //IP的对象  一台电脑的对象
        InetAddress address = InetAddress.getByName("kris");
        System.out.println(address);

        String name = address.getHostName();
        System.out.println(name);

        String ip = address.getHostAddress();
        System.out.println(ip);
    }
}
