package com.beidao.mall.cart.service.impl;

import com.beidao.mall.cart.service.CartService;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {


    //添加到购物车
    @Override
    public void addToCart(Long skuId, Integer skuNum) {

        //1、必须时登录状态  获取当前登录用户id （作为redis的hash类型的key值）
        //从threadLocal中获取用户信息


        //2、因为购物车放在redis中存储
        //从redis中获取购物车数据  根据key值+skuid获取(hash类型key+field)


        //3、如果商品在购物车中存在 ---把商品数量添加


        //4、如果添加的商品在购物车中不存在 ---直接把商品添加到购物车中---添加到redis里面
        //远程调用实现：通过nacos+openFeign实现 ---》根据skuid获取商品sku信息



    }
}
