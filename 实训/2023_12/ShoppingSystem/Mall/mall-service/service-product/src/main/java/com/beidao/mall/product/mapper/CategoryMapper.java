package com.beidao.mall.product.mapper;


import com.beidao.mall.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //1、所有一级分类
    List<Category> selectOneCategory();
}
