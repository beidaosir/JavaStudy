package com.hnu.dao;

import com.hnu.bean.Food;

import java.util.List;

/*
1、查看餐品列表-根据商家id
2、根据条件搜索商家餐品
3、添加餐品
4、修改餐品
5、删除餐品
6、根据编号查餐品
 */
public interface FoodDao {

    /*
    查看商品列表(根据商家ID)
    businessID  指定的商家id
    return 查到的餐品集合
     */
    public List<Food> listFoodByBusinessId(Integer businessId);

    /*
    根据编号查询餐品
    foodId 指定编号
    return 对应的餐品对象
     */
    public Food getFoodById(Integer foodId);

    /*
    添加餐品
    food 目标对象
    return 成功与否
     */
    public boolean saveFood(Food food);

    /*
    修改餐品
    food 要修改的目标对象
    return 成功与否
     */
    public boolean updateFood(Food food);

    /*
    删除餐品
    food 要删除的目标对象
    return 成功与否
     */
    public boolean removeFood(Integer foodId);
}
