package cn.neusoft.service;

import cn.neusoft.po.Food;
import cn.neusoft.query.FoodQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IFoodService extends IService<Food> {

    Page<Food> getByPage(FoodQuery foodQuery);

}
