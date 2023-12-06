package com.hnu.mapper;

import com.hnu.po.Food;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FoodMapper extends BaseMapper<Food>,PageMapper<Food>{

    //    int add(Food t);
//    int update(Food t);
//    int del(Integer id);
//    Food getById(Integer id);
//    List<Food> getAll();
//    int getCount(BaseQuery baseQuery);
//    List<Food> getByPage(BaseQuery baseQuery);

    @Update("update t_food set foodExplain=#{foodExplain} where foodId=#{foodId}")
    int updateExplain(Food food);

    @Select("select foodExplain from t_food where foodId=#{foodId}")
    String getExplain(Integer foodId);

}
