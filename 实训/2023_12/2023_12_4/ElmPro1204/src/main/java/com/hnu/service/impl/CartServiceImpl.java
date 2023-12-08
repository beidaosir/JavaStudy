package com.hnu.service.impl;

import com.hnu.mapper.CartItemMapper;
import com.hnu.mapper.CartMapper;
import com.hnu.po.Cart;
import com.hnu.po.CartItem;
import com.hnu.service.CartService;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CartItemMapper cartItemMapper;

    /**
     * 获取餐车及餐车中的所有餐车项
     * @param businessId
     * @param userId
     * @return
     */
    @Transactional
    @Override
    public ResponseObj getCart(Integer businessId, Integer userId) {

        if(businessId == null || userId==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }

        Cart cart = cartMapper.getCart(businessId, userId);
        if (cart==null){
            return ResponseObj.ERROR(9002,"购物车不存在");
        }
        List<CartItem> itemList = cartItemMapper.getByCartId(cart.getCartId());
        //把所有的餐车项放入餐车
        cart.setCartItems(itemList);
        return ResponseObj.SUCCESS(cart);
    }

    /**
     * 添加购物车项
     * @param item  指定添加的购物车项
     * @param businessId  商家id
     * @param userId  用户id
     * @return
     */
    @Transactional
    @Override
    public ResponseObj addCartItem(CartItem item,Integer businessId,Integer userId) {

        if (item==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }

        if(businessId == null || userId==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }

        //1、尝试获取购物车
        Cart cart = cartMapper.getCart(businessId, userId);
        System.out.println("查询到的购物车："+cart);
        //2、如果购物车为空 创建购物车
        if (cart==null){
            cart = new Cart(null,businessId,userId);
            //添加完成会自动生成主键  从cart对象中就可以获取到  cart.getCartId()
            cartMapper.insert(cart);
            System.out.println("新增购物车："+cart);
        }
        //3、存在购物车
        else{
            //4、查看该购物车项之前是否存在
            CartItem selItem = cartItemMapper.getByFoodIdAndCartId(item.getFoodId(),cart.getCartId());
            System.out.println("查询购物车项是否存在："+selItem);
            //5、购物车项已经存在了  修改数量即可
            if(selItem!=null){
                selItem.setNumber(selItem.getNumber()+1);
                int i = cartItemMapper.updateByPrimaryKey(selItem);
                return i>0?ResponseObj.SUCCESS("数量已更新"):ResponseObj.ERROR(888,"更新数量失败");
            }
        }
        //5、购物车新创建的  购物车项肯定不存在  需要添加
        //   购物车存在了 但是购物车项不存在  需要添加
        //设置购物车id
        item.setCartId(cart.getCartId());
        int insert = cartItemMapper.insert(item);
        return insert>0?ResponseObj.SUCCESS("添加购物车项成功"):ResponseObj.ERROR(888,"添加购物车项失败");
    }

    @Override
    public ResponseObj removeCartItem(Integer itemId) {

        if (itemId==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }

        int i = cartItemMapper.deleteByPrimaryKey(itemId);
        return i>0?ResponseObj.SUCCESS("删除购物车项成功"):ResponseObj.ERROR(8001,"删除购物车项失败");
    }

    @Override
    public ResponseObj changeItemNumber(CartItem cartItem) {

        if (cartItem==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }

        if (cartItem.getItemId()==null || cartItem.getNumber()==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }

        int i = cartItemMapper.updateByPrimaryKey(cartItem);
        return i>0?ResponseObj.SUCCESS("数量已更新"):ResponseObj.ERROR(888,"更新数量失败");
    }


}
