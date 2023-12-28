package com.beidao.mall.manager.mapper;

import com.beidao.mall.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {

    //品牌列表
    List<Brand> findByPage();

    //添加
    void save(Brand brand);
}
