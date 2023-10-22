package com.hnu.view;

import com.hnu.bean.Business;

public interface BusinessView {

    /**
     * 查询全部并输出
     */
    public void listBusinessAll();

    /**
     * 根据条件搜索  并输出
     */
    public void searchBusiness();

    /**
     * 添加商家信息
     */
    public void saveBusiness();


    /**
     * 删除商家
     */
    public void removeBusiness();

    /**
     * 修改商家
     */
    public void updateBusiness();


    /*
    商家登录
     */
    public Business login();


    //以下的商家行为 都是登录成功之后的行为  商家只能对自己的信息进行操作
    //所以不能让商家输入编号 不然就可以操作其他商家信息
    /*
    商家通过自己的编号查看自己所有信息
    商家入口程序中登陆成功之后会得到登陆成功的商家对象
    商家对象中包含正在登录的商家编号
    必须传入参数
     */

    /*
    查看商家信息  自己查看
     */
    public void showBusinessInfo(Business business);


    /*
     * 修改商家 商家自己修改
     */
    public void updateBusinessBySelf(Business business);

    /*
    修改密码
     */
    public void updateBusinessByPassword(Business business);

/*








    */


}