package cn.neusoft.test1;

import cn.neusoft.bean.User;
import cn.neusoft.dynamicproxy.CglibFactory;
import cn.neusoft.dynamicproxy.UserService;

/**
 * 代理模式：
 *    类型  业务代码和关注点代码不分离  导致关注点代码重复n次
 *    核心的业务由目标类来完成  重复的事情可以交给代理类来完成
 *
 *  静态代理：
 *    目标类 必须实现接口   代理类  和目标类实现相同的接口
 */
public class ProxyTest03 {

    public static void main(String[] args) {
        //1、创建目标类对象
        UserService userService = new UserService();
        //2、创建代理类对象
        CglibFactory factory = new CglibFactory();
        factory.setTarget(userService);

        UserService proxy = (UserService)factory.getProxy();

        System.out.println(proxy.getClass());

        proxy.add();

        System.out.println("-----------------");

        proxy.update();

        System.out.println("-----------------");

        proxy.del();
    }



}
