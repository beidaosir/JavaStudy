package com.hnu.service;

import com.hnu.po.Food;

public interface FoodService extends BaseService<Food>{

    boolean updateExplain(Food food);

    String getExplain(Integer foodId);

}