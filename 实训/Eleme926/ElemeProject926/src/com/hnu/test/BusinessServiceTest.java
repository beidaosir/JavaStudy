package com.hnu.test;

import com.hnu.bean.Business;
import com.hnu.service.BusinessService;
import com.hnu.service.impl.BusinessServiceImpl;

import java.util.List;

public class BusinessServiceTest {

    public static void main(String[] args) {

        /*
        第一个方法的测试结果
         */
       /* BusinessService businessService = new BusinessServiceImpl();
        List<Business> businessList= businessService.listBusiness();
        for (Business business:businessList) {
            System.out.println(business);
        }*/


        /*
        第二个方法的测试结果
         */
         BusinessService businessService = new BusinessServiceImpl();
        List<Business> businessList = businessService.listBusiness("小吃", "经七路");
        /*System.out.println("商家编号\t商家名称\t商家地址\t商家简介\t起送费\t配送费");*/
        for (Business business:businessList) {
            System.out.println(business);
        }

    }
}
