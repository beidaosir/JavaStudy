package cn.neusoft.test;  //声明该类所在的包

/*
switch分支语句
 */
public class Demo02 {

    public static void main(String[] args) {

        /*
         ()中的表达式只能是以下类型：byte short int char String
         在case模块中使用break：执行完成这个模块就跳出分支语句
         */

        int number = 1;

        switch (number){
            case 1:
                System.out.println("查话费");
                break;
            case 2:
                System.out.println("查流量");
                break;
            case 9:
                System.out.println("人工服务");
                break;
            default:
                System.out.println("没有提供该服务");
        }

    }

}
