package com.hnu.mapper;

import com.hnu.po.CartItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(CartItem record);

    CartItem selectByPrimaryKey(Integer itemId);

    List<CartItem> selectAll();

    int updateByPrimaryKey(CartItem record);

    //通过购物车编号获取购物车项
    List<CartItem> getByCartId(Integer cartId);

    @Select("select itemId,number from t_cart_item where foodId=#{foodId} and cartId=#{cartId}")
    CartItem getByFoodIdAndCartId(@Param("foodId") Integer foodId,@Param("cartId") Integer cartId);

}