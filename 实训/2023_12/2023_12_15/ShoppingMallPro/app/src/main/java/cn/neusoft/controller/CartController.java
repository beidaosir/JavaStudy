package cn.neusoft.controller;

import cn.neusoft.po.Cart;
import cn.neusoft.po.CartItem;
import cn.neusoft.service.ICartService;
import cn.neusoft.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService cartService;

    @GetMapping("/{bid}/{uid}")
    public ResponseObj getCart(@PathVariable("bid") Integer bid,@PathVariable("uid") Integer uid){
        Cart cart = cartService.getCart(bid, uid);
        return ResponseObj.SUCCESS(cart);
    }

    @PostMapping("/{bid}/{uid}")
    public ResponseObj addItem(@RequestBody CartItem cartItem,@PathVariable("bid") Integer bid,@PathVariable("uid") Integer uid){
        boolean b = cartService.addCartItem(cartItem, bid, uid);
        return b?ResponseObj.SUCCESS("添加购物车成功"):ResponseObj.ERROR(60001,"添加购物车失败");
    }

    @PutMapping
    public ResponseObj updateItem(@RequestBody CartItem cartItem){
        boolean b = cartService.changeNumber(cartItem);
        return b?ResponseObj.SUCCESS("修改数量成功"):ResponseObj.ERROR(60002,"修改数量失败");
    }

    @DeleteMapping("/{id}")
    public ResponseObj removeCartItem(@PathVariable("id") Integer itemId){
        boolean b = cartService.removeItem(itemId);
        return b?ResponseObj.SUCCESS("删除购物车项成功"):ResponseObj.ERROR(60003,"删除购物车项失败");
    }

}
