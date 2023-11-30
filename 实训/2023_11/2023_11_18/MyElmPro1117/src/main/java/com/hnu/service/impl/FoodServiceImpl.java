package com.hnu.service.impl;

import com.hnu.mapper.FoodMapper;
import com.hnu.po.Food;
import com.hnu.query.BaseQuery;
import com.hnu.service.FoodService;
import com.hnu.util.MybatisUtil;
import com.hnu.vo.PageBean;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FoodServiceImpl implements FoodService {

    SqlSession sqlSession;
    FoodMapper foodMapper;

    public FoodServiceImpl() {
        sqlSession = MybatisUtil.getSession();
        foodMapper = sqlSession.getMapper(FoodMapper.class);
    }


    @Override
    public boolean add(Food food) {

        if (food == null) {
            return false;
        }
        if (food.getFoodName() == null || "".equals(food.getFoodName())) {
            return false;
        }

        try {
            int add = foodMapper.add(food);
            sqlSession.commit();
            return add > 0;
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return false;
    }

    @Override
    public boolean update(Food food) {
        if (food == null) {
            return false;
        }
        if (food.getFoodId() == null) {
            return false;
        }
        if (food.getFoodName() == null || "".equals(food.getFoodName())) {
            return false;
        }

        try {
            int i = foodMapper.update(food);
            sqlSession.commit();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return false;
    }

    @Override
    public boolean del(Integer id) {

        if (id == null) {
            return false;
        }

        try {
            int i = foodMapper.del(id);
            sqlSession.commit();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return false;
    }

    @Override
    public Food getById(Integer id) {

        if (id == null) {
            return null;
        }

        try {
            return foodMapper.getById(id);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sqlSession.close();
        }

        return null;
    }

    @Override
    public List<Food> getAll() {


        try {
            return foodMapper.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return null;
    }

    @Override
    public PageBean<Food> getByPage(BaseQuery baseQuery) {

        if (baseQuery == null) {
            return null;
        }
        if (baseQuery.getCurrentPage() == null) {
            baseQuery.setCurrentPage(1);
        }
        if (baseQuery.getPageNumber() == null) {
            baseQuery.setPageNumber(5);
        }

        PageBean<Food> foodPageBean = new PageBean<>();

        try {
            int count = foodMapper.getCount(baseQuery);
            foodPageBean.setTotalPages(count);

            int totalPages = count % baseQuery.getPageNumber() == 0 ? count / baseQuery.getPageNumber() : (count / baseQuery.getPageNumber() + 1);
            foodPageBean.setTotalPages(totalPages);

            List<Food> list = foodMapper.getByPage(baseQuery);
            foodPageBean.setData(list);

            return foodPageBean;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return null;
    }

    @Override
    public boolean addBatch(List<Food> list) {
        try {
            for (Food food:list) {
                int add = foodMapper.add(food);
                if (add<0){
                    sqlSession.rollback();
                    return false;
                }
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return false;
    }

    @Override
    public boolean delBatch(Integer[] ids) {

        try {
            for (Integer id:ids) {
                int del = foodMapper.del(id);
                if (del<0){
                    sqlSession.rollback();
                    return false;
                }
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }


        return false;
    }
}
