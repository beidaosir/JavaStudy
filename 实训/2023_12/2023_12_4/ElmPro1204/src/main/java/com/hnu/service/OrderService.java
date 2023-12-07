package com.hnu.service;

import com.hnu.po.Order;
import com.hnu.po.OrderDetail;
import com.hnu.query.BaseQuery;
import com.hnu.vo.ResponseObj;

import java.util.List;

/**
 * 订单业务和订单详情业务都在这
 */
public interface OrderService {

    /*
    管理员查订单  全部分页 可以搜索
    商家查询订单  默认要带上商家编号
     */
    ResponseObj getByPage(BaseQuery baseQuery);


    /*
    顾客查询订单
     */
    ResponseObj getByUserId(Integer userId);


    /*
    顾客下单
    添加订单  成功之后  使用生成的订单编号添加订单详情
     */
    ResponseObj createOrder(Order order, List<OrderDetail> orderDetailList);

    /**
     * 删除订单
     * 根据订单编号 删除订单及关联的订单详情
     */
    ResponseObj removeOrder(Long orderId);


}
