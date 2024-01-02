package com.beidao.mall.order.mapper;


import com.beidao.mall.model.entity.order.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper {

    //5、添加数据到orderItem表
    void save(OrderItem orderItem);
}
