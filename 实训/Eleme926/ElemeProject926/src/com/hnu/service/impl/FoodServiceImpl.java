package com.hnu.service.impl;

import com.hnu.bean.Food;
import com.hnu.data.ElemeDB;
import com.hnu.service.FoodService;
import com.hnu.util.ElemeUtil;
import com.hnu.util.IOUtils;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService {


    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> result = new ArrayList<>();

        for (int i = 0; i < ElemeDB.FOOD_LIST.size(); i++) {
            Food food = ElemeDB.FOOD_LIST.get(i);
            if (food.getBusinessId().equals(businessId)){

                result.add(food);
            }

        }

        return result;
    }

    @Override
    public Food getFoodById(Integer foodId) {

        for (int i = 0; i < ElemeDB.FOOD_LIST.size(); i++) {
            Food food = ElemeDB.FOOD_LIST.get(i);
            if (food.getFoodId().equals(foodId)){
                return food;
            }
        }
        return null;
    }

    @Override
    public boolean saveFood(Food food) {

        //添加时 编号采用自动生成 所以调用createId
        int foodId = ElemeUtil.createId();
        food.setFoodId(foodId);

        boolean add = ElemeDB.FOOD_LIST.add(food);
        writeFoodArray();
        return add;
    }

    @Override
    public boolean updateFood(Food food) {

        for (int i = 0; i < ElemeDB.FOOD_LIST.size(); i++) {
            Food current = ElemeDB.FOOD_LIST.get(i);
            if (current.getFoodId().equals(food.getFoodId())) {
                ElemeDB.FOOD_LIST.set(i,food);
                writeFoodArray();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeFood(Integer foodId) {
        for (int i = 0; i < ElemeDB.FOOD_LIST.size(); i++) {
            Food food = ElemeDB.FOOD_LIST.get(i);
            if (food.getFoodId().equals(foodId)) {
                boolean remove = ElemeDB.FOOD_LIST.remove(food);
                writeFoodArray();
                return remove;
            }
        }

        return false;
    }

    //只能是给餐品文件中写入商家集合
    private void writeFoodArray() {
        try {
            IOUtils.writeObj(ElemeDB.FOOD_File,ElemeDB.FOOD_LIST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
