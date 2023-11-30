package cn.neusoft.dynamicproxy;

public class UserService {

    public void add(){
        System.out.println("添加用户");
        int i = 10/0;
    }

    public void update(){
        System.out.println("修改用户");
    }

    public void del(){
        System.out.println("删除用户");
    }

}
