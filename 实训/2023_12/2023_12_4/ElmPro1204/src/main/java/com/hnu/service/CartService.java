package com.hnu.service;

import com.hnu.po.CartItem;
import com.hnu.vo.ResponseObj;

/**
 * Cart的业务和CartItem的业务都写在这个接口
 */
public interface CartService {

    //创建购物车
    ResponseObj createCart(Integer businessId, Integer userId);

    //添加购物车项
    ResponseObj addCartItem(CartItem item);

    //移除购物车项
    ResponseObj removeCartItem(Integer itemId);

    //更新购物车项的数量
    ResponseObj changeItemNumber(Integer itemId,Integer newNumber);

    /*
    通过用户id和商家id先查询购物车id
    通过购物车id查询购物车项
    查询购物车项
     */
    ResponseObj getItems(Integer businessId,Integer userId);
}
