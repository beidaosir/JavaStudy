package com.beidao.mall.product.service.impl;

import com.beidao.mall.model.dto.h5.ProductSkuDto;
import com.beidao.mall.model.entity.product.ProductSku;
import com.beidao.mall.product.mapper.ProductSkuMapper;
import com.beidao.mall.product.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    //2、根据销量排序 获取前10条记录
    @Override
    public List<ProductSku> selectProductSkuBySale() {
        return productSkuMapper.selectProductSkuBySale();
    }


    //分页查询
    @Override
    public PageInfo<ProductSku> findByPage(Integer page, Integer limit, ProductSkuDto productSkuDto) {

        PageHelper.startPage(page, limit);
        List<ProductSku> productSkuList = productSkuMapper.findByPage(productSkuDto);
        return new PageInfo<>(productSkuList);

    }
}
