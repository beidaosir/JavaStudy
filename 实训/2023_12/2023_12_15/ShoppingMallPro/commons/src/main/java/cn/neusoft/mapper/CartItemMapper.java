package cn.neusoft.mapper;

import cn.neusoft.po.Cart;
import cn.neusoft.po.CartItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartItemMapper extends BaseMapper<CartItem> {

}