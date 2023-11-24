package com.hnu.view;

import com.hnu.bean.Food;

import java.util.List;

public interface FoodView {


    public void listFoodByBusinessId(Integer businessId);

    /*
    给当前商家自己添加 所以商家编号需要传参
     */
    public void saveFood(Integer businessId);

    /*
    修改当前商家自己的餐品  所以也要传入商家id进行对比
     */
    public void updateFood(Integer businessId);

    /*
    只能删除自己家的餐品 所以商家编号也要进行对比
     */
    public void removeFood(Integer businessId);



}
