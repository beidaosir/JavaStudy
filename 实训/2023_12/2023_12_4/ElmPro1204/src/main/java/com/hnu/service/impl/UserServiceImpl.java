package com.hnu.service.impl;

import com.hnu.mapper.UserMapper;
import com.hnu.po.User;
import com.hnu.query.UserQuery;
import com.hnu.service.UserService;
import com.hnu.vo.PageBean;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional
    @Override
    public ResponseObj register(User user) {

        if (user==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        if (user.getPhone()==null || "".equals(user.getPhone())){
            return ResponseObj.ERROR(888,"手机号为空");
        }

        User phoneUser = userMapper.selectByPhone(user.getPhone());
        if (phoneUser!=null){
            return ResponseObj.ERROR(888,"手机号已注册");
        }

        user.setUsername("用户"+ UUID.randomUUID().toString().replaceAll("-",""));
        user.setPassword("654321");
        return userMapper.insert(user)>0?ResponseObj.SUCCESS():ResponseObj.ERROR(666,"更新数据失败");
    }

    @Transactional
    @Override
    public ResponseObj update(User user) {
        if (user==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        return userMapper.updateByPrimaryKey(user)>0?ResponseObj.SUCCESS():ResponseObj.ERROR(666,"更新数据失败");
    }

    @Override
    public ResponseObj unRegister(Integer userId) {
        if (userId==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        return userMapper.deleteByPrimaryKey(userId)>0?ResponseObj.SUCCESS():ResponseObj.ERROR(666,"更新数据失败");
    }

    @Override
    public ResponseObj login(User user) {
        if (user==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        if (user.getUsername()==null || "".equals(user.getUsername()) || user.getPassword() == null || "".equals(user.getPassword())){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        User loginUser = userMapper.selectByUP(user.getUsername(), user.getPassword());
        return loginUser==null?ResponseObj.ERROR(777,"登录失败"):ResponseObj.SUCCESS(loginUser);
    }

    @Override
    public ResponseObj getByPgae(UserQuery baseQuery) {

        if (baseQuery==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }

        if (baseQuery.getCurrentPage()==null){
            baseQuery.setCurrentPage(1);
        }

        if (baseQuery.getPageNumber()==null){
            baseQuery.setPageNumber(5);
        }

        PageBean<User> pageBean = new PageBean<>();
        //1、查询总记录
        int totalRows = userMapper.getCount(baseQuery);
        pageBean.setTotalRows(totalRows);

        //2、计算总页数
        int totalPages = totalRows%baseQuery.getPageNumber()==0?totalRows/baseQuery.getPageNumber():totalRows/baseQuery.getPageNumber()+1;
        pageBean.setTotalPages(totalPages);

        //3、查询当前页的集合
        List<User> data = userMapper.getByPage(baseQuery);
        pageBean.setData(data);

        return ResponseObj.SUCCESS(pageBean);

    }

    @Override
    public ResponseObj getById(Integer userId) {
        if (userId==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        User user = userMapper.selectByPrimaryKey(userId);
        return ResponseObj.SUCCESS(user);
    }

    @Override
    public ResponseObj loginByPhone(String phone, String validCode) {
        if (phone==null || "".equals(phone)){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        if (validCode==null || "".equals(validCode)){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        User user = userMapper.selectByPhone(phone);
        if (user!=null && "1234".equals(validCode)){
            return ResponseObj.SUCCESS(user);
        }
        return  ResponseObj.ERROR(777,"登录失败");
    }
}
