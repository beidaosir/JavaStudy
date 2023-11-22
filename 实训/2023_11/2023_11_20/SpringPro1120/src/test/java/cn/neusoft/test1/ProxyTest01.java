package cn.neusoft.test1;

import cn.neusoft.staticproxy.IStuService;
import cn.neusoft.staticproxy.StuService;
import cn.neusoft.staticproxy.StuServiceProxy;

/**
 * 代理模式：
 *    类型  业务代码和关注点代码不分离  导致关注点代码重复n次
 *    核心的业务由目标类来完成  重复的事情可以交给代理类来完成
 *
 *  静态代理：
 *    目标类 必须实现接口   代理类  和目标类实现相同的接口
 */
public class ProxyTest01 {

    public static void main(String[] args) {
        //1、创建目标类对象
        IStuService stuService = new StuService();
        //2、创建代理类对象
        IStuService stuServiceProxy = new StuServiceProxy(stuService);
        stuServiceProxy.add();
        System.out.println("---------------");
        stuServiceProxy.update();
        System.out.println("---------------");
        stuServiceProxy.del();

    }

}
