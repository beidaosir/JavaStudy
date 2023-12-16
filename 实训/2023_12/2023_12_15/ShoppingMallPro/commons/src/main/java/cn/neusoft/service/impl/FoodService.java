package cn.neusoft.service.impl;

import cn.neusoft.mapper.FoodMapper;
import cn.neusoft.po.Food;
import cn.neusoft.query.FoodQuery;
import cn.neusoft.service.IFoodService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FoodService extends ServiceImpl<FoodMapper, Food> implements IFoodService {

    @Override
    public Page<Food> getByPage(FoodQuery foodQuery) {
        Page<Food> foodIPage = new Page<>(foodQuery.getCurrent(),foodQuery.getSize());
        return baseMapper.getRefBusiness(foodIPage, foodQuery);
    }
}
