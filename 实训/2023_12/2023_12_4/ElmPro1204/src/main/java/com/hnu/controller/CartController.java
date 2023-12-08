package com.hnu.controller;

import com.hnu.po.CartItem;
import com.hnu.service.CartService;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/app/{bid}/{uid}")
    public ResponseObj getCart(@PathVariable("bid") Integer bid,@PathVariable("uid") Integer uid){
        return cartService.getCart(bid, uid);
    }

    @PostMapping("/app/{bid}/{uid}")
    public ResponseObj addItem(@RequestBody CartItem cartItem,@PathVariable("bid") Integer bid,@PathVariable("uid") Integer uid){
        return cartService.addCartItem(cartItem,bid,uid);
    }

    @PutMapping("/app")
    public ResponseObj updateItem(@RequestBody CartItem cartItem){
        return cartService.changeItemNumber(cartItem);
    }

    @DeleteMapping("/app/{id}")
    public ResponseObj removeCartItem(@PathVariable("id") Integer itemId){
        return cartService.removeCartItem(itemId);
    }

}
