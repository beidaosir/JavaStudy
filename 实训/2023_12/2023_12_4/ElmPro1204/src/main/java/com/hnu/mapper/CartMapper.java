package com.hnu.mapper;

import com.hnu.po.Cart;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(Cart record);

    Cart selectByPrimaryKey(Integer cartId);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart record);

    @Select("select cartId,businessId,userId from t_cart where businessId=#{bid} and userId=#{uid}")
    Cart getCart(@Param("bid") Integer bid,@Param("uid") Integer uid);
}