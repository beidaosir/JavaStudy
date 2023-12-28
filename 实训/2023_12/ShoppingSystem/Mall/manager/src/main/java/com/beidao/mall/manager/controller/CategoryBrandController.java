package com.beidao.mall.manager.controller;

import com.beidao.mall.manager.service.CategoryBrandService;
import com.beidao.mall.model.dto.product.CategoryBrandDto;
import com.beidao.mall.model.entity.product.CategoryBrand;
import com.beidao.mall.model.vo.common.Result;
import com.beidao.mall.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/product/categoryBrand")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService ;

    //分类品牌条件分页查询
    @GetMapping("/{page}/{limit}")
    public Result findByPage(@PathVariable Integer page,
                                                      @PathVariable Integer limit,
                                                      CategoryBrandDto CategoryBrandDto) {
        PageInfo<CategoryBrand> pageInfo =
                categoryBrandService.findByPage(page, limit, CategoryBrandDto);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }
}