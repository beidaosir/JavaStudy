package com.hnu.mapper;

import com.hnu.po.Cart;
import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(Cart record);

    Cart selectByPrimaryKey(Integer itemId);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart record);
}