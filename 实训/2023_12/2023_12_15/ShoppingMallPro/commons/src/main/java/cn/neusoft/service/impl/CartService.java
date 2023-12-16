package cn.neusoft.service.impl;

import cn.neusoft.mapper.CartItemMapper;
import cn.neusoft.mapper.CartMapper;
import cn.neusoft.po.Cart;
import cn.neusoft.po.CartItem;
import cn.neusoft.service.ICartService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService extends ServiceImpl<CartMapper, Cart> implements ICartService {

    @Autowired
    CartItemMapper cartItemMapper;

    @Override
    public Cart getCart(Integer businessId, Integer userId) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("businessId",businessId);
        queryWrapper.eq("userId",userId);

        Cart cart = baseMapper.selectOne(queryWrapper);
        if (cart==null){
            throw new RuntimeException();
        }

        queryWrapper = new QueryWrapper();
        queryWrapper.eq("cartId",cart.getCartId());

        List<CartItem> itemList = cartItemMapper.selectList(queryWrapper);
        cart.setCartItems(itemList);

        return cart;
    }

    @Override
    public boolean addCartItem(CartItem item, Integer businessId, Integer userId) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("businessId",businessId);
        queryWrapper.eq("userId",userId);

        Cart cart = baseMapper.selectOne(queryWrapper);

        if (cart==null){
            cart = new Cart(null,businessId,userId,null);
            int insert = baseMapper.insert(cart);
            if (insert<=0){
                throw new RuntimeException();
            }
        }else{
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("foodId",item.getFoodId());
            CartItem cartItem = cartItemMapper.selectOne(queryWrapper);

            if (cartItem!=null){
                cartItem.setNumber(cartItem.getNumber()+1);
                int i = cartItemMapper.updateById(cartItem);
                return i>0;
            }

        }

        item.setCartId(cart.getCartId());
        int insert = cartItemMapper.insert(item);

        return insert>0;
    }

    @Override
    public boolean changeNumber(CartItem item) {
        return cartItemMapper.updateById(item)>0;
    }

    @Override
    public boolean removeItem(Integer itemId) {
        return cartItemMapper.deleteById(itemId)>0;
    }
}
