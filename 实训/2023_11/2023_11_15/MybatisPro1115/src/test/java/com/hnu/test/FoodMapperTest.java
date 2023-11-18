package com.hnu.test;

import com.hnu.mapper.FoodMapper;
import com.hnu.po.Food;
import com.hnu.query.FoodQuery;
import com.hnu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class FoodMapperTest {

    //关联查询  只有一个sql
    @Test
    public void testGetById(){
        SqlSession session = MybatisUtil.getSession();
        FoodMapper mapper = session.getMapper(FoodMapper.class);
        Food food = mapper.getById(113);
        System.out.println(food.getFoodId()+" "+food.getFoodName()+"  "+food.getFoodExplain()+" "+food.getFoodPrice()+" "+food.getBusiness().getBid()+" "+food.getBusiness().getBusinessName());
    }

    //分开多次查询  多个sql
    @Test
    public void testGetAll(){
        SqlSession session = MybatisUtil.getSession();
        FoodMapper mapper = session.getMapper(FoodMapper.class);
        List<Food> foodList = mapper.getAll();
        for (Food food: foodList) {
            System.out.println(food.getFoodId()+" "+food.getFoodName()+"  "+food.getFoodExplain()+" "+food.getFoodPrice()+" "+food.getBusiness().getBid()+" "+food.getBusiness().getBusinessName());
        }
    }

    @Test
    public void testGetByPage(){
        SqlSession session = MybatisUtil.getSession();
        FoodMapper mapper = session.getMapper(FoodMapper.class);
        FoodQuery baseQuery = new FoodQuery();
        baseQuery.setBusinessId(10001);
        //baseQuery.setFoodName("馄饨");
        List<Food> foodList = mapper.getByPage(baseQuery);
        for (Food food: foodList) {
            System.out.println(food);
        }
    }

    @Test
    public void testGetCount(){
        SqlSession session = MybatisUtil.getSession();
        FoodMapper mapper = session.getMapper(FoodMapper.class);
        FoodQuery baseQuery = new FoodQuery();
//        baseQuery.setFoodName("馄饨");
        int count = mapper.getCount(baseQuery);
        System.out.println(count);
    }

}
