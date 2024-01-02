package com.beidao.mall.order.mapper;


import com.beidao.mall.model.entity.order.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapper {


    //添加数据到orderInfo表
    void save(OrderInfo orderInfo);
}
