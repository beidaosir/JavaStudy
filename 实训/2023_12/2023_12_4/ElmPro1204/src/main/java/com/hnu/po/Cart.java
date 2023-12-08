package com.hnu.po;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Cart {

    private Integer cartId;

    private Integer businessId; //关联的商品编号

    private Integer userId; //关联的用户编号

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CartItem> cartItems; //购物车项集合

    public Cart() {
    }

    public Cart(Integer cartId, Integer businessId, Integer userId) {
        this.cartId = cartId;
        this.businessId = businessId;
        this.userId = userId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", businessId=" + businessId +
                ", userId=" + userId +
                ", cartItems=" + cartItems +
                '}';
    }
}