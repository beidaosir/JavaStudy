package com.beidao.mall.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.beidao.mall.model.entity.product.Category;
import com.beidao.mall.product.mapper.CategoryMapper;
import com.beidao.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    //1、所有一级分类
    @Override
    public List<Category> selectOneCategory() {

        //1、查询redis 是否有所有一级分类   //category:one
        String categoryOneJson = redisTemplate.opsForValue().get("category:one");

        //2、如果redis包含所有一级分类 直接返回
        if (StringUtils.hasText(categoryOneJson))
        {
            List<Category> existCategoryList = JSON.parseArray(categoryOneJson, Category.class);
            return existCategoryList;
        }

        //3、如果redis没有所有一级分类 查询数据库 把数据库查询内容返回 并且查询内容放到redis里面
        List<Category> categoryList = categoryMapper.selectOneCategory();

        //查询内容放到redis里面
        redisTemplate.opsForValue().set("category:one",JSON.toJSONString(categoryList),
                7, TimeUnit.DAYS);


        return categoryList;
    }


    //查询所有分类  树形封装
    //category::all
    // 查询所有分类，树型
    @Cacheable(value = "category" , key = "'all'")
    @Override
    public List<Category> findCategoryTree() {
        List<Category> categoryList = categoryMapper.findAll();
        //查询所有分类，返回list集合
        List<Category> oneCategoryList = categoryList.stream().
                filter(item -> item.getParentId().longValue() == 0)
                .collect(Collectors.toList());
        //通过条件parentid=0得到所有的一级分类
        //遍历一级分类的集合，通过id=parentid ，得到下面的二级分类
        //遍历二级分类的集合，通过id=parentid ，得到下面的三级分类
        if(!CollectionUtils.isEmpty(oneCategoryList)) {
            oneCategoryList.forEach(oneCategory -> {
                List<Category> twoCategoryList = categoryList.stream().filter(item -> item.getParentId().longValue() == oneCategory.getId().longValue()).collect(Collectors.toList());
                oneCategory.setChildren(twoCategoryList);

                if(!CollectionUtils.isEmpty(twoCategoryList)) {
                    twoCategoryList.forEach(twoCategory -> {
                        List<Category> threeCategoryList = categoryList.stream().filter(item -> item.getParentId().longValue() == twoCategory.getId().longValue()).collect(Collectors.toList());
                        twoCategory.setChildren(threeCategoryList);
                    });
                }
            });
        }
        return oneCategoryList;
    }

   /* @Cacheable(value = "category",key = "'all'")
    @Override
    public List<Category> findCategoryTree() {

        //1、查询所有分类  返回list集合
        List<Category> allCategoryList = categoryMapper.findAll();

        //2、遍历所有分类list集合  通过条件parent_id=0得到所有一级分类
        List<Category> oneCategoryList =
                allCategoryList.stream().filter(item -> item.getParentId()
                                .longValue() == 0)
                        .collect(Collectors.toList());

        //3、遍历所有一级分类list集合  通过条件id = parent_id得到所有二级分类
        oneCategoryList.forEach(oneCategory -> {
            List<Category> twoCategoryList = allCategoryList.stream().filter(item -> item.getParentId() == oneCategory.getId())
                    .collect(Collectors.toList());

            //把二级分类封装到一级分类里面

            oneCategory.setChildren(twoCategoryList);

            //4、遍历所有二级分类list集合  通过条件id = parent_id得到所有三级分类
            twoCategoryList.forEach(twoCategory -> {
                List<Category> threeCategoryList = allCategoryList.stream().filter(item -> item.getParentId() == twoCategory.getId())
                        .collect(Collectors.toList());

                //把3级分类封装到2级分类里面

                twoCategory.setChildren(threeCategoryList);


            });
        });


        return oneCategoryList;
    }*/
}
