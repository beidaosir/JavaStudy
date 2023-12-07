package com.hnu.mapper;

import com.hnu.po.OrderDetail;
import java.util.List;

public interface OrderDetailMapper {
    int insert(OrderDetail record);

    List<OrderDetail> selectAll();
}