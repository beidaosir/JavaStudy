package com.itheima.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.UserVO;

import java.util.List;

public interface IUserService extends IService<User> {

    //扣减用户余额
    void deductBalance(Long id, Integer money);

    //查询用户及其地址
    UserVO queryUserAndAddressById(Long userId);

    //根据id批量查询用户
    List<UserVO> queryUserAndAddressByIds(List<Long> ids);
}
