package com.beidao.mall.order.service.impl;

import com.beidao.mall.feign.cart.CartFeignClient;
import com.beidao.mall.model.entity.h5.CartInfo;
import com.beidao.mall.model.entity.order.OrderItem;
import com.beidao.mall.model.vo.h5.TradeVo;
import com.beidao.mall.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {


    @Autowired
    private CartFeignClient cartFeignClient;

    //确认下单
    @Override
    public TradeVo getTrade() {

        //远程调用获取购物车选中商品列表
        List<CartInfo> cartInfoList = cartFeignClient.getAllCkecked();

        //创建list集合用于封装订单项
        List<OrderItem> orderItemList = new ArrayList<>();
        for (CartInfo  cartInfo: cartInfoList){
            OrderItem orderItem = new OrderItem();

            orderItem.setSkuId(cartInfo.getSkuId());
            orderItem.setSkuName(cartInfo.getSkuName());
            orderItem.setSkuNum(cartInfo.getSkuNum());
            orderItem.setSkuPrice(cartInfo.getCartPrice());
            orderItem.setThumbImg(cartInfo.getImgUrl());
            orderItemList.add(orderItem);
        }

        //获取订单支付的总金额
        BigDecimal totalAmount = new BigDecimal(0);
        for(OrderItem orderItem : orderItemList) {
            totalAmount = totalAmount.add(orderItem.getSkuPrice().multiply(new BigDecimal(orderItem.getSkuNum())));
        }


        TradeVo tradeVo = new TradeVo();
        tradeVo.setTotalAmount(totalAmount);
        tradeVo.setOrderItemList(orderItemList);
        return tradeVo;
    }
}
