package com.hnu.service.impl;

import com.hnu.bean.Business;
import com.hnu.data.ElemeDB;
import com.hnu.service.BusinessService;

import java.util.ArrayList;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {

    /**
     * 可能商家名称叫美味小吃   沙县小吃    搜索的词汇是小吃    经七路纬七路
     * @param businessName   商家名称条件
     * @param businessAddress  商家地址条件
     * @return
     */
    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {

        //最后查到的数据都放在这个集合
        ArrayList<Business> resultList = new ArrayList<>();

        //遍历查找素有符合条件的对象
        for (int i = 0; i < ElemeDB.BUSINESS_LIST.size(); i++) {

            Business business = ElemeDB.BUSINESS_LIST.get(i);
            if (business.getBusinessName().contains(businessName)
                    && business.getBusinessAddress().contains(businessAddress)){

                //符合条件的加入最终要返回的集合
                resultList.add(business);
            }
        }

        //返回的集合如果长度为0  那就是没有符合条件的
        return resultList;


    }


    /**
     * 获取所有的商家信息
     * @return  所有商家信息的集合
     */

    @Override
    public List<Business> listBusiness() {
        return ElemeDB.BUSINESS_LIST;
    }

    @Override
    public boolean saveBusiness(String businessName) {
        return false;
    }

    @Override
    public boolean removeBusiness(int businessId) {
        return false;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return null;
    }

    @Override
    public boolean updateBusiness(Business business) {
        return false;
    }

    @Override
    public boolean updateBusinessByPassword(Integer businessId, String password) {
        return false;
    }

    @Override
    public Business login(Integer businessId, String password) {
        return null;
    }
}
