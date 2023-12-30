package com.beidao.mall.product.service.impl;

import com.beidao.mall.model.entity.product.ProductSku;
import com.beidao.mall.product.mapper.ProductSkuMapper;
import com.beidao.mall.product.service.ProductService;
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
}
