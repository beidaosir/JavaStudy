package cn.neusoft.mapper;

import cn.neusoft.po.Food;
import cn.neusoft.query.FoodQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FoodMapper extends BaseMapper<Food>{


   Page<Food> getRefBusiness(Page<Food> page, @Param("foodQuery") FoodQuery foodQuery);

}
