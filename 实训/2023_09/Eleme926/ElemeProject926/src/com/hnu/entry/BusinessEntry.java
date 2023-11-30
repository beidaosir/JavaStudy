package com.hnu.entry;

import com.hnu.bean.Business;
import com.hnu.view.BusinessView;
import com.hnu.view.FoodView;
import com.hnu.view.impl.BusinessViewImpl;
import com.hnu.view.impl.FoodViewImpl;

import java.util.Scanner;

public class BusinessEntry {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 饿了么商家后台管理系统  \t\t\t|");
        System.out.println("---------------------------------------------------------");
        BusinessView businessView = new BusinessViewImpl();


        Business business = businessView.login();

        if (business == null) {

            System.out.println("商家编号或者密码错误，请重试...");
            return;

        }
        System.out.println("===欢迎您来到商家后台===");
        while (true) {
            System.out.println("请选择您要进行的操作：");
            System.out.println("1、查看商家信息");
            System.out.println("2、修改商家信息");
            System.out.println("3、修改密码");
            System.out.println("4、管理餐品");
            System.out.println("5、退出系统");

            String what = input.next();
            //测试商家账号：13116422
            switch (what) {
                case "1":
                    System.out.println("==为您查看商家信息==");
                    businessView.showBusinessInfo(business);
                    break;
                case "2":
                    System.out.println("==为您修改商家信息==");
                    businessView.updateBusinessBySelf(business);
                    break;
                case "3":
                    System.out.println("==为您修改密码==");
                    businessView.updateBusinessByPassword(business);
                    break;
                case "4":
                    //将当前餐厅的编号传入餐品管理的二级菜单
                    foodEntry(business.getBusinessId());
                    break;
                case "5":
                    System.out.println("==再见，欢迎您下次再来！==");
                    return;
                default:
                    System.out.println("暂未开通相关服务！");
            }
        }
    }

    /*
    二级菜单
     */
    public static void foodEntry(Integer businessId){
        //餐品测试id  374382631

        Scanner scanner = new Scanner(System.in);
        FoodView foodView = new FoodViewImpl();
        System.out.println("======管理餐品======");

        while (true) {
            System.out.println("\n==二级菜单(食品管理)==\n 1.查看食品列表\n 2.新增食品\n 3.修改食品\n 4.删除食品\n 5.返回上一级菜单\n");
            System.out.println("请输入您要做的选择:");
            String what = scanner.next();

            switch (what) {
                case "1":
                    System.out.println("===查看食品列表===");
                    foodView.listFoodByBusinessId(businessId);
                    break;
                case "2":
                    System.out.println("===新增食品===");
                    foodView.saveFood(businessId);
                    break;
                case "3":
                    System.out.println("===修改食品===");
                    foodView.updateFood(businessId);
                    break;
                case "4":
                    System.out.println("===删除食品===");
                    foodView.removeFood(businessId);
                    break;
                case "5":
                    System.out.println("==给您返回上一级菜单==");
                    return;
                default:
                    System.out.println("暂未开通该服务！");
            }
        }

    }

}
