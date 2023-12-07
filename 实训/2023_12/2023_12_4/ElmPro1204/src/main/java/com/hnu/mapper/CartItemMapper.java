package com.hnu.mapper;

import com.hnu.po.CartItem;

import java.util.List;

public interface CartItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(CartItem record);

    CartItem selectByPrimaryKey(Integer itemId);

    List<CartItem> selectAll();

    int updateByPrimaryKey(CartItem record);
}