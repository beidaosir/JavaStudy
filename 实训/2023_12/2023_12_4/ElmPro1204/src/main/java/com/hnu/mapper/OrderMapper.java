package com.hnu.mapper;

import com.hnu.po.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    Order selectByPrimaryKey(Long orderId);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}