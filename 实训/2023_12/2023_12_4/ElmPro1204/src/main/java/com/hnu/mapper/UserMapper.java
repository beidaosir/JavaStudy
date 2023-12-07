package com.hnu.mapper;

import com.hnu.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends PageMapper<User>{

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByUP(@Param("username") String username, @Param("password") String password);

    User selectByPhone(String phone);
}