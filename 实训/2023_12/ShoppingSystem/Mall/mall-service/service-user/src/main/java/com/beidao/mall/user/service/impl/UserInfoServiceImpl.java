package com.beidao.mall.user.service.impl;

import com.beidao.mall.common.exception.BeidaoException;
import com.beidao.mall.model.dto.h5.UserRegisterDto;
import com.beidao.mall.model.entity.user.UserInfo;
import com.beidao.mall.model.vo.common.ResultCodeEnum;
import com.beidao.mall.user.mapper.UserInfoMapper;
import com.beidao.mall.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    //注册
    @Override
    public void register(UserRegisterDto userRegisterDto) {

        //1、userRegisterDto获取数据
        String username = userRegisterDto.getUsername();//用户名就是手机号
        String password = userRegisterDto.getPassword();
        String nickName = userRegisterDto.getNickName();
        String code = userRegisterDto.getCode();

        //校验参数
        if(StringUtils.isEmpty(username) ||
                StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(nickName) ||
                StringUtils.isEmpty(code)) {
            throw new BeidaoException(ResultCodeEnum.DATA_ERROR);
        }

        //2、验证码校验
        //2.1、从redis中获取发送验证码
        String redisCode = redisTemplate.opsForValue().get(username);

        //2.2、获取输入的验证码  进行比对
        if (!redisCode.equals(code)){

            throw new BeidaoException(ResultCodeEnum.VALIDATECODE_ERROR);
        }

        //3、检验用户名不能重复
        UserInfo userInfo = userInfoMapper.selectByUserName(username);
        if (userInfo != null)
        {
            //存在相同用户名
            throw new BeidaoException(ResultCodeEnum.USER_NAME_IS_EXISTS);

        }


        //4、封装添加数据  调用方法添加数据库
        //不等于空  new一个对象
        userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userInfo.setNickName(nickName);
        userInfo.setPhone(username);
        userInfo.setStatus(1);
        userInfo.setSex(0);
        userInfo.setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
        userInfoMapper.save(userInfo);

        //5、从redis中删除发送的验证码
        redisTemplate.delete(username);

    }
}
