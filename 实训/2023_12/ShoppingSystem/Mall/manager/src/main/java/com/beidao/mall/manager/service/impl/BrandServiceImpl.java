package com.beidao.mall.manager.service.impl;

import com.beidao.mall.manager.mapper.BrandMapper;
import com.beidao.mall.manager.service.BrandService;
import com.beidao.mall.model.entity.product.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {


    @Autowired
    private BrandMapper brandMapper;

    //品牌列表
    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<Brand> list = brandMapper.findByPage();
        PageInfo<Brand> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    //添加
    @Override
    public void save(Brand brand) {
        brandMapper.save(brand);
    }
}
