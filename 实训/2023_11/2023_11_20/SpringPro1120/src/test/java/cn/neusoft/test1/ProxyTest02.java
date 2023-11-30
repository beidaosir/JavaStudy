package cn.neusoft.test1;


import cn.neusoft.dynamicproxy.IStuService;
import cn.neusoft.dynamicproxy.ProxyFactory;
import cn.neusoft.dynamicproxy.StuService;

/**
 * 代理模式：
 *    类型  业务代码和关注点代码不分离  导致关注点代码重复n次
 *    核心的业务由目标类来完成  重复的事情可以交给代理类来完成
 *
 *  静态代理：
 *    目标类 必须实现接口   代理类  和目标类实现相同的接口
 */
public class ProxyTest02 {

    public static void main(String[] args) {
        //1、创建目标类对象
        IStuService stuService = new StuService();
        //2、创建代理类对象
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(stuService);
        IStuService stuServiceProxy = (IStuService)proxyFactory.getProxy();

        System.out.println(stuServiceProxy.getClass());

        stuServiceProxy.add();
        System.out.println("--------------");
        stuServiceProxy.update();
        System.out.println("--------------");
        stuServiceProxy.del();
    }



}
