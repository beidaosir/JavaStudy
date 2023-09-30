package com.hnu.service.impl;

import com.hnu.bean.Business;
import com.hnu.data.ElemeDB;
import com.hnu.service.BusinessService;
import com.hnu.util.ElemeUtil;
import com.hnu.util.IOUtils;

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
        //根据商家名字将商家对象创建出来
        Business business = new Business();
        business.setBusinessName(businessName);

        //生成唯一的编号 随机数
        int id = ElemeUtil.createId();

        //在此处应该判断id之前是否存在
        business.setBusinessId(id);

        //设置一个默认密码
        business.setPassword("111111");

        //这些留给商家自己设置  但是必须有初值
        //因为该对象已经创建出来了  展示的时候不能都显示null
        business.setBusinessAddress("");
        business.setBusinessExplain("");
        business.setStarPrice(0.0);
        business.setDeliveryPrice(0.0);
        boolean add =  ElemeDB.BUSINESS_LIST.add(business);

        //将添加之后的集合写入文件
        writeBusinessArray();

        return add;

    }

    @Override
    public boolean removeBusiness(int businessId) {
        //循环遍历查找对应的商家
        for (int i = 0; i < ElemeDB.BUSINESS_LIST.size(); i++) {
            Business business = ElemeDB.BUSINESS_LIST.get(i);
            if (business.getBusinessId().equals(businessId)){
                //将找到的商家移除掉  并返回结果
                boolean remove =  ElemeDB.BUSINESS_LIST.remove(business);

                //将删除之后的集合写入文件
                writeBusinessArray();
                return remove;
            }
        }

        return false;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        for (int i = 0; i < ElemeDB.BUSINESS_LIST.size(); i++) {
            Business business = ElemeDB.BUSINESS_LIST.get(i);
            if (business.getBusinessId().equals(businessId)){
                //将找到的商家移除掉  并返回结果
                return business;
            }
        }
        return null;
    }


    /**
     * 编号不能改
     * 根据编号找对应的，替换
     * @param business 需要修改的新的商家对象
     * @return
     */
    @Override
    public boolean updateBusiness(Business business) {
        for (int i = 0; i < ElemeDB.BUSINESS_LIST.size(); i++) {
            Business current = ElemeDB.BUSINESS_LIST.get(i);
            if (current.getBusinessId().equals(business.getBusinessId())){
                ElemeDB.BUSINESS_LIST.set(i,business);

                //将修改之后的集合写入文件
                writeBusinessArray();
                return true;
            }
        }
        return false;
    }

    /**
     * 修改密码
     * @param businessId  商家编号
     * @param password  新密码
     * @return
     */
    @Override
    public boolean updateBusinessByPassword(Integer businessId, String password) {
        for (int i = 0; i < ElemeDB.BUSINESS_LIST.size(); i++) {
            Business current = ElemeDB.BUSINESS_LIST.get(i);
            //找到要修改密码的目标商家
            if (current.getBusinessId().equals(businessId)) {
                //重新设置密码
                current.setPassword(password);
                //修改之后执行写操作
                writeBusinessArray();
                return true;
            }

        }
        return false;
    }



    /**
     * 登录
     * @param businessId  账号
     * @param password  密码
     * @return
     */
    @Override
    public Business login(Integer businessId, String password) {
        for (int i = 0; i < ElemeDB.BUSINESS_LIST.size(); i++) {
            Business current = ElemeDB.BUSINESS_LIST.get(i);
            if (current.getBusinessId().equals(businessId)
                    && current.getPassword().equals(password)){
                return current;
            }
        }
        return null;
    }


    //只能是给商家文件中写入商家集合
    private void writeBusinessArray() {
        try {
            IOUtils.writeObj(ElemeDB.BUSINESS_File,ElemeDB.BUSINESS_LIST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
