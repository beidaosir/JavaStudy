package com.beidao.mall.product.service;

import com.beidao.mall.model.entity.product.Category;

import java.util.List;

public interface CategoryService {

    //1、所有一级分类
    List<Category> selectOneCategory();
}
