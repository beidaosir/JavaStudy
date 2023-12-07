package com.hnu.service;

import com.hnu.po.User;
import com.hnu.query.UserQuery;
import com.hnu.vo.ResponseObj;

public interface UserService {

    //注册
    ResponseObj register(User user);

    //修改
    ResponseObj update(User user);

    //注销
    ResponseObj unRegister(Integer userId);

    //登录
    ResponseObj login(User user);

    //分页查询
    ResponseObj getByPgae(UserQuery userQuery);

    //通过id查询
    ResponseObj getById(Integer userId);

    //通过手机号和验证码登录
    ResponseObj loginByPhone(String phone,String validCode);
}