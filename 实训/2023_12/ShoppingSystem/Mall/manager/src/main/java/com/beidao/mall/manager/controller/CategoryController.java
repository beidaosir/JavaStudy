package com.beidao.mall.manager.controller;

import com.beidao.mall.manager.service.CategoryService;
import com.beidao.mall.model.entity.product.Category;
import com.beidao.mall.model.vo.common.Result;
import com.beidao.mall.model.vo.common.ResultCodeEnum;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/admin/product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //导出功能
    @GetMapping("/exportData")
    public void exportData(HttpServletResponse response){
        categoryService.exportData(response);
    }


    //分类列表  每次查询一层数据---懒加载
    //select * from category where parent_id = id
    @GetMapping("/findCategoryList/{id}")
    public Result findCategory(@PathVariable Long id){
        List<Category> list = categoryService.findCategoryList(id);
        return Result.build(list, ResultCodeEnum.SUCCESS);

    }





}
