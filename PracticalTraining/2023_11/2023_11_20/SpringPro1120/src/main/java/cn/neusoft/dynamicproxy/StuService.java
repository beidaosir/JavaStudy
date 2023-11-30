package cn.neusoft.dynamicproxy;

/**
 * 目标类  关注业务
 */
public class StuService implements IStuService {

    public void add(){
        System.out.println("执行添加操作");
    }

    public void update(){
        System.out.println("执行修改操作");
    }

    public void del(){
        System.out.println("执行删除操作");
    }

}
