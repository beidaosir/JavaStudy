package com.beidao.mall.product.service.impl;

import com.beidao.mall.model.entity.product.Category;
import com.beidao.mall.product.mapper.CategoryMapper;
import com.beidao.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;


    //1、所有一级分类
    @Override
    public List<Category> selectOneCategory() {
        return categoryMapper.selectOneCategory();
    }
}
