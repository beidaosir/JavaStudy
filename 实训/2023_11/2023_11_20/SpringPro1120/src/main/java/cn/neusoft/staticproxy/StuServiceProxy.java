package cn.neusoft.staticproxy;

/**
 * 代理类：
 *    维护一个目标类的对象
 *    业务调用目标类的
 *    代理中主要做关注点的内容  事务处理
 */
public class StuServiceProxy implements IStuService{

    IStuService stuService;

    public StuServiceProxy(IStuService stuService) {
        this.stuService = stuService;
    }

    @Override
    public void add() {
        System.out.println("开启事务");
        //执行核心类的业务
        stuService.add();
        System.out.println("关闭事务");
    }

    @Override
    public void update() {
        System.out.println("开启事务");
        stuService.update();
        System.out.println("关闭事务");
    }

    @Override
    public void del() {
        System.out.println("开启事务");
        stuService.del();
        System.out.println("关闭事务");
    }
}
