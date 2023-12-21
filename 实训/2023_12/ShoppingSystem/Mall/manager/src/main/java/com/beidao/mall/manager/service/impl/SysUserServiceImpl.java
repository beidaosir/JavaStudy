package com.beidao.mall.manager.service.impl;

import com.alibaba.fastjson.JSON;
import com.beidao.mall.common.exception.BeidaoException;
import com.beidao.mall.manager.mapper.SysUserMapper;
import com.beidao.mall.manager.service.SysUserService;
import com.beidao.mall.model.dto.system.LoginDto;
import com.beidao.mall.model.entity.system.SysUser;
import com.beidao.mall.model.vo.common.ResultCodeEnum;
import com.beidao.mall.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired //寻找一个匹配的bean并将其注入到该字段中。
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    //用户登录
    @Override
    public LoginVo login(LoginDto loginDto) {
        //1.获取提交过来的用户名  loginDto获取
        String userName = loginDto.getUserName();

        //2.根据用户名username查询数据库表sys_user表
        SysUser sysUser = sysUserMapper.selectUserInfoByUserName(userName);

        //3.查询不到用户 用户不存在 返回错误信息
       /* if(sysUser == null){

            throw new RuntimeException("用户名不存在");
        }*/

        //更改成自定义异常处理
        if (sysUser == null){
            throw new BeidaoException(ResultCodeEnum.LOGIN_ERROR);
        }

        //4.查询到信息  用户存在
        //5. 获取输入的密码，比较输入的密码与数据库中是否一致
        String database_password = sysUser.getPassword();

        /*String input_password = loginDto.getPassword();

        //把输入的密码先进行加密再进行比较  -- 数据库中的密码是加密过的  使用md5方式加密
        input_password = DigestUtils.md5DigestAsHex(input_password.getBytes());*/

        //改进一下
        String input_password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());

        //比较
        /*if (!input_password.equals(database_password)){
            throw new RuntimeException("密码错误");
        }*/

        //自定义异常替换
        if (!input_password.equals(database_password)){
            throw new BeidaoException(ResultCodeEnum.LOGIN_ERROR);
        }


        //6.密码一致 登录成功 反之则失败
        //7.登录成功  生成用户唯一标识token
        String token = UUID.randomUUID().toString().replaceAll("-","");


        //8.把登录成功用户信息放到redis中 key:token  value:用户信息  时间  单位

        //将用户信息转成字符串传入到redis中    JSON.toJSONString(sysUser)
        redisTemplate.opsForValue()
                .set("user:login"+token,
                        JSON.toJSONString(sysUser),
                        7,
                        TimeUnit.DAYS);


        //9.返回loginVo对象  ->token
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);

        return loginVo;
    }
}
