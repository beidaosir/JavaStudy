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
      /*  BusinessService businessService = new BusinessServiceImpl();
        List<Business> businessList= businessService.listBusiness();
        for (Business business:businessList) {
            System.out.println(business);
        }
*/

        /*
        第二个方法的测试结果
         */
         /*BusinessService businessService = new BusinessServiceImpl();
        List<Business> businessList = businessService.listBusiness("小吃", "经七路");
        *//*System.out.println("商家编号\t商家名称\t商家地址\t商家简介\t起送费\t配送费");*//*
        for (Business business:businessList) {
            System.out.println(business);
        }*/

        /* 添加方法测试 */
       /* BusinessService businessService = new BusinessServiceImpl();
        businessService.saveBusiness("苏记奶酪");
        List<Business> businessesList = businessService.listBusiness();
        for (Business business:businessesList) {
            System.out.println(business);
        }

*/
        /*BusinessService businessService = new BusinessServiceImpl();
        boolean isOk = businessService.saveBusiness("苏记奶酪");
        System.out.println("添加--"+isOk);*/

        /* 测试删除 */
       /* BusinessService businessService = new BusinessServiceImpl();
        boolean b = businessService.removeBusiness(32323);
        System.out.println("删除--"+b);
        List<Business> businessesList = businessService.listBusiness();
        for (Business business:businessesList) {
            System.out.println(business);
        }*/

        /* 测试通过id查询 */
        /*BusinessService businessService = new BusinessServiceImpl();
        Business businessById = businessService.getBusinessById(3232);
        System.out.println(businessById);*/

        /* 测试修改 */
        /*BusinessService businessService = new BusinessServiceImpl();
        Business business = new Business(32323,"111111",
                "赵记烩面馆","红旗区经开区","就是好吃",13.0,8.8);
        boolean b = businessService.updateBusiness(business);
        System.out.println("修改---"+b);

        List<Business> businessesList = businessService.listBusiness();
        for (Business bs:businessesList) {
            System.out.println(bs);
        }*/

        /* 测试修改密码 */
       /* BusinessService businessService = new BusinessServiceImpl();
        businessService.updateBusinessByPassword(32322,"897634");
        Business business = businessService.getBusinessById(32322);
        System.out.println(business.getBusinessId()+"   "+business.getBusinessName()+"   "
                +business.getPassword());*/

        /* 测试登录 */
     /*   BusinessService businessService = new BusinessServiceImpl();
        Business business = businessService.login(32323, "111111");
        System.out.println(business);
*/
    }
}
