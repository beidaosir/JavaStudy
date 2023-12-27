package com.beidao.mall.manager.mapper;

import com.beidao.mall.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    // 1、根据id条件进行查询
    List<Category> selectCategoryByParentId(Long id);

    // 判断每个分类是否有下一层分类
    int selectCountByParentId(Long id);
}
