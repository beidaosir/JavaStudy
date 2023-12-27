package com.beidao.mall.manager.service.impl;

import com.beidao.mall.manager.mapper.CategoryMapper;
import com.beidao.mall.manager.service.CategoryService;
import com.beidao.mall.model.entity.product.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    //分类列表  每次查询一层数据
    @Override
    public List<Category> findCategoryList(Long id) {

        // 1、根据id条件进行查询
        //select * from category where parent_id = id
        List<Category> categoryList = categoryMapper.selectCategoryByParentId(id);

        //2、遍历返回list集合   为了让前端能够显示出分层结构
        // 判断每个分类是否有下一层分类  如果有---》设置hasChildren = true
        if (!CollectionUtils.isEmpty(categoryList)){
            categoryList.forEach(category -> {
                // 判断每个分类是否有下一层分类
                //select count(*) from category where parent_id=1
                int count = categoryMapper.selectCountByParentId(category.getId());

                if (count>0){
                    //下一层分类
                    category.setHasChildren(true);
                }else {
                    category.setHasChildren(false);
                }

            });
        }


        return categoryList;
    }
}
