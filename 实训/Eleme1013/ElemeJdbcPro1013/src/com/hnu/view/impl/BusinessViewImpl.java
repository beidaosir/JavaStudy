package com.hnu.view.impl;

import com.hnu.bean.Business;
import com.hnu.dao.BusinessDao;
import com.hnu.dao.impl.BusinessDaoImpl;
import com.hnu.view.BusinessView;

import java.util.List;
import java.util.Scanner;

/*
1、接收用户输入
2、调用service
3、给用户操作结果的反馈
 */
public class BusinessViewImpl implements BusinessView {

    BusinessDao businessDao = new BusinessDaoImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void listBusinessAll() {

        System.out.println("====为您查看所有商家====");

        List<Business> businessesList = businessDao.listBusiness("","");

        if (businessesList==null || businessesList.size()==0){
            System.out.println("暂无数据，请添加信息再查询！");
            return;
        }
        for (Business business:businessesList) {
            System.out.println(business);
        }
    }

    @Override
    public void searchBusiness() {

        System.out.println("====为您搜索商家====");

        String businessName = "";
        String businessAddress = "";

        System.out.println("您要输入商家名称吗？(y/n)");
        String inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("请输入商家名称");
            businessName = scanner.next();
        }

        System.out.println("您要输入商家地址吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("请输入商家地址：");
            businessAddress = scanner.next();
        }

        System.out.println("您的搜索条件是：名称："+businessName+"  地址："+businessAddress);

        List<Business> businessList = businessDao.listBusiness(businessName, businessAddress);
        if (businessList.size()==0 || businessList ==null){
            System.out.println("很抱歉，没有搜索到您需要的商家信息");
        }else{

            for (Business business:businessList) {
                System.out.println(business);
            }
        }


    }

    @Override
    public void saveBusiness() {
        System.out.println("====为您添加商家====");
        System.out.println("请输入商家名称：");
        String businessName = scanner.next();
        boolean b = businessDao.saveBusiness(businessName);
        System.out.println("您的添加操作"+(b?"成功":"失败"));

    }

    @Override
    public void removeBusiness() {
        System.out.println("====为您删除商家====");
        System.out.println("请输入您要删除的商家编号：");
        int businessId = scanner.nextInt();
        System.out.println("您确定要删除吗？(y/n)");
        String inputStr = scanner.next();
        if ("y".equals(inputStr)){
            boolean b = businessDao.removeBusiness(businessId);
            System.out.println("您的删除操作"+(b?"成功":"失败"));
            return;
        }
        System.out.println("您取消了删除！");



    }

    @Override
    public void updateBusiness() {
        System.out.println("====为您修改商家====");
        System.out.println("请您输入需要修改的商家编号：");
        int businessId = scanner.nextInt();
        Business business = businessDao.getBusinessById(businessId);
        if (business == null){
            System.out.println("您要修改的商家不存在，请查看输入的编号是否正确。");
            return;
        }
        System.out.println("您要修改商家名称吗？(y/n)");
        String inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家名称：");
            business.setBusinessName(scanner.next());
        }

        System.out.println("您要修改商家地址吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家新地址：");
            business.setBusinessAddress(scanner.next());
        }

        System.out.println("您要修改商家简介吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家新简介：");
            business.setBusinessExplain(scanner.next());
        }

        System.out.println("您要修改商家起送价吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家新起送价：");
            business.setStarPrice(scanner.nextDouble());
        }

        System.out.println("您要修改商家新配送费吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家新配送费：");
            business.setDeliveryPrice(scanner.nextDouble());
        }

        System.out.println("您确定要修改吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            boolean b = businessDao.updateBusiness(business);
            System.out.println("您的修改操作："+ (b?"成功":"失败"));
            return;
        }
        System.out.println("您取消了修改操作！");





    }

    @Override
    public Business login() {

        System.out.println("请输入商家编号：");
        int businessId = scanner.nextInt();
        System.out.println("请输入商家密码：");
        String businessPassword = scanner.next();

        return businessDao.login(businessId,businessPassword);
    }

    @Override
    public void showBusinessInfo(Business business) {
        System.out.println("商家编号："+business.getBusinessId());
        System.out.println("商家名称："+business.getBusinessName());
        System.out.println("商家简介："+business.getBusinessExplain());
        System.out.println("商家地址："+business.getBusinessAddress());
        System.out.println("商家起送费：￥"+business.getStarPrice());
        System.out.println("商家配送费：￥"+business.getDeliveryPrice());


    }

    @Override
    public void updateBusinessBySelf(Business business) {

        System.out.println("您要修改商家名称吗？(y/n)");
        String inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家名称：");
            business.setBusinessName(scanner.next());
        }

        System.out.println("您要修改商家地址吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家新地址：");
            business.setBusinessAddress(scanner.next());
        }

        System.out.println("您要修改商家简介吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家新简介：");
            business.setBusinessExplain(scanner.next());
        }

        System.out.println("您要修改商家起送价吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家新起送价：");
            business.setStarPrice(scanner.nextDouble());
        }

        System.out.println("您要修改商家新配送费吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            System.out.println("输入商家新配送费：");
            business.setDeliveryPrice(scanner.nextDouble());
        }

        System.out.println("您确定要修改吗？(y/n)");
        inputStr = scanner.next();
        if ("y".equals(inputStr)){
            boolean b = businessDao.updateBusiness(business);
            System.out.println("您的修改操作："+ (b?"成功":"失败"));
            return;
        }
        System.out.println("您取消了修改操作！");

    }

    /*
    修改密码必须输入原来的密码
    输入新的密码
    重复输入新的密码  再次输入验证密码 两次密码必须一致
     */
    @Override
    public void updateBusinessByPassword(Business business) {

        System.out.println("请您输入原始密码：");
        String oldPass = scanner.next();

        if (!business.getPassword().equals(oldPass)){
            System.out.println("您的原始密码输入错误，请重试！");
            return;
        }

        System.out.println("请您输入您要修改的新密码：");
        String newPass1 = scanner.next();
        System.out.println("请您重复输入您要修改的新密码：");
        String newPass2 = scanner.next();

        if (!newPass2.equals(newPass1)){
            System.out.println("您两次输入的密码不一致，请重试！");
            return;
        }

        boolean b = businessDao.updateBusinessByPassword(business.getBusinessId(), newPass1);
        System.out.println("修改密码"+(b?"成功":"失败"));

    }
}
