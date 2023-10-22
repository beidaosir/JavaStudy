package com.hnu.dao;

import com.hnu.bean.Business;

import java.util.List;

/*
    针对商家的服务
     */
public interface BusinessDao {

    /**
     * 根据商家名称和商家地址进行搜索
     * @param businessName  商家名称条件
     * @param businessAddress 商家地址条件
     * @return  搜索的结果的集合
     */
    public List<Business> listBusiness(String businessName, String businessAddress);

    /**
     * 获取所有的商家信息
     * @return  所有商家信息的集合
     */
    public List<Business> listBusiness();


    /**
     * 添加商家信息  平台的行为
     * 平台只添加商家名称  密码默认111111  商家编号自动生成   其他信息等商家登录之后自己修改
     * 关于添加的返回值
     *    添加成功与否   boolean
     *    添加了几条记录   成功返回1   失败返回0  int
     *    将添加成功的商家编号返回   Integer
     *    将添加成功的商家对象返回   Business
     */
    public boolean saveBusiness(String businessName);

    /**
     * 删除商家,根据商家编号删除  平台行为
     * @param businessId  商家编号
     * @return 删除成功返回true  失败返回false
     */
    public boolean removeBusiness(int businessId);


    /**
     * 通过编号查询商家   平台行为
     * @param businessId  商家编号
     * @return  查到的商家对象  查不到返回null
     */

    public Business getBusinessById(Integer businessId);

    /**
     * 修改商家信息   平台商家 都可以修改
     * @param business 需要修改的新的商家对象
     * @return  修改成功返回true 失败返回false
     */
    public boolean updateBusiness(Business business);


    /**
     * 修改商家密码   商家行为
     * @param businessId  商家编号
     * @param password  新密码
     * @return  修改成功返回true  失败返回false
     */
    public boolean updateBusinessByPassword(Integer businessId,String password);

    /**
     * 登录  商家行为
     * @param businessId  账号
     * @param password  密码
     * @return  登录成功的商家对象  登录失败返回null
     */
    public Business login(Integer businessId,String password);




}
