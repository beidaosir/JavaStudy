package com.hnu.entry;

import com.hnu.bean.Admin;
import com.hnu.view.AdminView;
import com.hnu.view.BusinessView;
import com.hnu.view.impl.AdminViewImpl;
import com.hnu.view.impl.BusinessViewImpl;
import java.util.Scanner;

/*
写流程
调用view
 */
public class AdminEntry {

    public static void main(String[] args) {

        BusinessView businessView = new BusinessViewImpl();
        AdminView adminView = new AdminViewImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("---------------饿了么管理员后台-------------");
        System.out.println("-----------------------------------------");

        Admin login = adminView.login();
        if (login==null){
            System.out.println("您输入的账号密码有误，登录失败，请重新尝试....");
            return;
        }

        System.out.println("============欢迎您"+login.getAdminName()+"进入管理员界面===============");
        while(true) {
            System.out.println("您需要进行以下哪个操作：");
            System.out.println("1.添加商家");
            System.out.println("2.修改商家");
            System.out.println("3.删除商家");
            System.out.println("4.查看所有商家");
            System.out.println("5.搜索商家");
            System.out.println("6.退出系统");
            System.out.println("请输入对应的序号即可");
            String what = scanner.next();

            switch (what) {
                case "1":
                    businessView.saveBusiness();
                    break;
                case "2":
                    businessView.updateBusiness();
                    break;
                case "3":
                    businessView.removeBusiness();
                    break;
                case "4":
                    businessView.listBusinessAll();
                    break;
                case "5":
                    businessView.searchBusiness();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("暂未提供该服务");
            }
        }

    }

}
