package com.beidao.mall.user.service;

import com.beidao.mall.model.entity.user.UserAddress;

import java.util.List;

public interface UserAddressService {

    //获取用户地址列表
    List<UserAddress> findUserAddressList();
}
