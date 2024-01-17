package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.itheima.mp.domain.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


public interface UserMapper extends BaseMapper<User> {


    //void updateBalanceByIds(@Param("ew") QueryWrapper<User> wrapper, int amount);//这两种方法都行
    void updateBalanceByIds(@Param(Constants.WRAPPER) QueryWrapper<User> wrapper, int amount);

    // 4.扣减余额
    @Update("UPDATE user SET balance = balance - #{money} WHERE id = #{id}")
    void deductMoneyById(@Param("id") Long id, @Param("money") Integer money);
}
