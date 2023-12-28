package com.beidao.mall.manager.service;

import com.beidao.mall.model.entity.product.Brand;
import com.github.pagehelper.PageInfo;

public interface BrandService {

    //品牌列表
    PageInfo<Brand> findByPage(Integer page, Integer limit);

    //添加
    void save(Brand brand);
}
