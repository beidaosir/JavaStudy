package com.beidao.mall.manager.service.impl;

import com.beidao.mall.manager.mapper.CategoryBrandMapper;
import com.beidao.mall.manager.service.CategoryBrandService;
import com.beidao.mall.model.dto.product.CategoryBrandDto;
import com.beidao.mall.model.entity.product.Brand;
import com.beidao.mall.model.entity.product.CategoryBrand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Autowired
    private CategoryBrandMapper categoryBrandMapper ;


    //分类品牌条件分页查询
    @Override
    public PageInfo<CategoryBrand> findByPage(Integer page,
                                              Integer limit,
                                              CategoryBrandDto categoryBrandDto) {
        //设置参数
        PageHelper.startPage(page , limit) ;
        List<CategoryBrand> list = categoryBrandMapper.findByPage(categoryBrandDto) ;
        PageInfo<CategoryBrand> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    //添加
    @Override
    public void save(CategoryBrand categoryBrand) {
        categoryBrandMapper.save(categoryBrand);
    }


    // 修改
    @Override
    public void updateById(CategoryBrand categoryBrand) {
        categoryBrandMapper.updateById(categoryBrand) ;
    }


    // 删除
    @Override
    public void deleteById(Long id) {
        categoryBrandMapper.deleteById(id) ;
    }


    //根据分类id查询对应品牌数据
    @Override
    public List<Brand> findBrandByCategoryId(Long categoryId) {
        return categoryBrandMapper.findBrandByCategoryId(categoryId);
    }
}
