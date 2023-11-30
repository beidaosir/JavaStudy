package cn.neusoft.dynamicproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class CglibFactory {

    //维护一个目标类对象
    Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /*
    获取代理对象
     */
    public Object getProxy(){
        Enhancer enhancer = new Enhancer();

        //设置父类
        enhancer.setSuperclass(target.getClass());

        //如何代理
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

                Object result = null;

                try{
                    System.out.println("开启事务");
                    result = method.invoke(target, objects);
                    System.out.println("提交事务");
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("回滚事务");
                }finally {
                    System.out.println("关闭事务");
                }

                return result;
            }
        });

        return enhancer.create();
    }

}
