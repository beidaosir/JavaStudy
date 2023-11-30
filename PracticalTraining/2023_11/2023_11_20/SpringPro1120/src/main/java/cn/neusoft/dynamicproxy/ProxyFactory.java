package cn.neusoft.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  动态代理：
 *    jdk代理  目标类必须实现接口
 *            可以为任何实现了接口的类型创建代理
 *
 *    cglib代理  目标类没有实现接口的
 *              使用继承
 *         如何使用  导入cglib的依赖
 *         spring已经集成了cglib
 */
public class ProxyFactory {

    //维护一个目标类对象
    Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //类加载器
                target.getClass().getInterfaces(), //目标类实现的接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //开启事务
                        System.out.println("开启事务");

                        //核心业务 目标类的方法
                        Object invoke = method.invoke(target, args);

                        //关闭事务
                        System.out.println("关闭事务");

                        return invoke;
                    }
                }
        );

    }
}
