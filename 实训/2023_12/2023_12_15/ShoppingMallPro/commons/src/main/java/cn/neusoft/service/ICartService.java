package cn.neusoft.service;

import cn.neusoft.po.Cart;
import cn.neusoft.po.CartItem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Cart的业务和CartItem的业务都写在这个接口
 */
public interface ICartService extends IService<Cart> {

    Cart getCart(Integer businessId,Integer userId);

    boolean addCartItem(CartItem item,Integer businessId,Integer userId);

    boolean changeNumber(CartItem item);

    boolean removeItem(Integer itemId);
}
