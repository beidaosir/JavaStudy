package com.hnu.service.impl;

import com.hnu.mapper.FoodMapper;
import com.hnu.po.Food;
import com.hnu.query.BaseQuery;
import com.hnu.service.FoodService;
import com.hnu.util.MybatisUtil;
import com.hnu.vo.PageBean;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;

    @Transactional
    @Override
    public boolean add(Food food) {
        if (food==null){
            return false;
        }
        if (food.getFoodName()==null || "".equals(food.getFoodName())){
            return false;
        }

        return foodMapper.add(food)>0;
    }

    @Transactional
    @Override
    public boolean update(Food food) {
        if (food==null){
            return false;
        }
        if (food.getFoodId()==null){
            return false;
        }
        if (food.getFoodName()==null || "".equals(food.getFoodName())){
            return false;
        }

        return foodMapper.update(food)>0;
    }

    @Transactional
    @Override
    public boolean del(Integer id) {

        if (id==null){
            return false;
        }

        return foodMapper.del(id)>0;
    }

    @Override
    public Food getById(Integer id) {
        if (id==null){
            return null;
        }
        return foodMapper.getById(id);
    }

    @Override
    public List<Food> getAll() {
        return foodMapper.getAll();
    }

    @Override
    public PageBean<Food> getByPage(BaseQuery baseQuery) {

        if (baseQuery==null){
            return null;
        }

        if (baseQuery.getCurrentPage()==null){
            baseQuery.setCurrentPage(1);
        }

        if(baseQuery.getPageNumber()==null){
            baseQuery.setPageNumber(5);
        }

        PageBean<Food> foodPageBean = new PageBean<>();

        int count = foodMapper.getCount(baseQuery);
        foodPageBean.setTotalRows(count);

        int totalPages = count%baseQuery.getPageNumber()==0?count/baseQuery.getPageNumber():count/baseQuery.getPageNumber()+1;
        foodPageBean.setTotalPages(totalPages);

        List<Food> list = foodMapper.getByPage(baseQuery);
        foodPageBean.setData(list);

        return foodPageBean;
    }

    @Transactional
    @Override
    public boolean addBatch(List<Food> list) throws Exception {

        for (Food food: list) {
            int add = foodMapper.add(food);
            if (add<=0){
                throw new Exception("添加中断");
            }
        }

        return true;
    }

    @Transactional
    @Override
    public boolean delBatch(Integer[] ids) throws Exception {
        for (Integer id: ids) {
            int del = foodMapper.del(id);
            if (del<=0){
                throw new Exception("删除中断");
            }
        }

        return true;
    }
}