package com.hnu.service;

import com.hnu.po.CartItem;
import com.hnu.vo.ResponseObj;

/**
 * Cart的业务和CartItem的业务都写在这个接口
 */
public interface CartService {

    //获取购物车
    ResponseObj getCart(Integer businessId,Integer userId);

    //添加购物车项
    ResponseObj addCartItem(CartItem item,Integer businessId,Integer userId);

    //移除购物车项
    ResponseObj removeCartItem(Integer itemId);

    //更新购物车项的数量
    ResponseObj changeItemNumber(CartItem item);
}
