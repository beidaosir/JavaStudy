package com.hnu.mapper;

import com.hnu.po.OrderDetail;
import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer detailId);

    List<OrderDetail> selectAll();

    int updateByPrimaryKey(OrderDetail record);
}