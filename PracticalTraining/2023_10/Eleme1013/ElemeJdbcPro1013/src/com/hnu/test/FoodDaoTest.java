package com.hnu.test;

import com.hnu.bean.Food;
import com.hnu.dao.FoodDao;
import com.hnu.dao.impl.FoodDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FoodDaoTest {

    @Test
    public void testList(){
        FoodDao foodDao = new FoodDaoImpl();
        List<Food> foods = foodDao.listFoodByBusinessId(10001);
        System.out.println(foods);
    }

    @Test
    public void testGetById(){
        FoodDao foodDao = new FoodDaoImpl();
        Food food = foodDao.getFoodById(111);
        System.out.println(food);
    }

    @Test
    public void testSave(){
        FoodDao foodDao = new FoodDaoImpl();
        Food food = new Food(null,"烧腊套餐","非常好吃",28.5,10001);
        boolean b = foodDao.saveFood(food);
        System.out.println(b);
    }


    @Test
    public void testUpdate(){
        FoodDao foodDao = new FoodDaoImpl();
        Food food = new Food(111,"鸭腿套餐","非常好吃",18.5,10001);
        boolean b = foodDao.updateFood(food);
        System.out.println(b);
    }

    @Test
    public void testRemove(){
        FoodDao foodDao = new FoodDaoImpl();
        boolean b = foodDao.removeFood(100);
        System.out.println(b);
    }

}
