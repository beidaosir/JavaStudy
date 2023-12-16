package cn.neusoft.service.impl;

import cn.neusoft.mapper.UserMapper;
import cn.neusoft.po.User;
import cn.neusoft.query.UserQuery;
import cn.neusoft.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User login(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper<>()
                .eq("username",username)
                .eq("password",password);
        User user = baseMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public User getByPhone(String phone) {
        QueryWrapper queryWrapper = new QueryWrapper<>()
                .eq("phone", phone);
        User user = baseMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public Page<User> getByPage(UserQuery userQuery) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(userQuery.getUsername()!=null){
            queryWrapper.like("username",userQuery.getUsername());
        }
        Page<User> page = new Page<>(userQuery.getCurrent(),userQuery.getSize());
        return baseMapper.selectPage(page, queryWrapper);
    }
}
