package com.beidao.mall.manager.controller;

import com.beidao.mall.manager.service.BrandService;
import com.beidao.mall.model.entity.product.Brand;
import com.beidao.mall.model.vo.common.Result;
import com.beidao.mall.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/admin/product/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    //品牌列表   page当前页  list每页记录数
    @GetMapping("/{page}/{limit}")
    public Result list(@PathVariable Integer page,
                       @PathVariable Integer limit){

        PageInfo<Brand> pageInfo = brandService.findByPage(page,limit);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }

    //添加
    @PostMapping("/save")
    public Result save(@RequestBody Brand brand){
        brandService.save(brand);

        return Result.build(null,ResultCodeEnum.SUCCESS);
    }


    //修改


    //删除


}
