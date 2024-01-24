package com.itheima.mp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.Address;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.AddressVO;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.enums.UserStatus;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    //扣减用户余额
    @Override
    @Transactional
    public void deductBalance(Long id, Integer money) {
        // 1.查询用户
        User user = getById(id);
        // 2.判断用户状态
        if (user == null || user.getStatus() == UserStatus.FREEZE) {
            throw new RuntimeException("用户状态异常");
        }
        // 3.判断用户余额
        if (user.getBalance() < money) {
            throw new RuntimeException("用户余额不足");
        }
        // 4.扣减余额 update tb_user set balance = balance - ?
        int remainBalance = user.getBalance() - money;
        lambdaUpdate()
                .set(User::getBalance, remainBalance) // 更新余额
                .set(remainBalance == 0, User::getStatus, UserStatus.FREEZE) // 动态判断，是否更新status
                .eq(User::getId, id)
                .eq(User::getBalance, user.getBalance()) // 乐观锁
                .update();
    }

    //查询用户及其地址
    @Override
    public UserVO queryUserAndAddressById(Long userId) {
        //1 、查询用户
        User user = getById(userId);
        if (user == null || user.getStatus()==UserStatus.FREEZE){
            throw new RuntimeException("用户状态异常！");
        }

        //2 、查询地址
        List<Address> addresses = Db.lambdaQuery(Address.class)
                .eq(Address::getUserId, userId).list();

        //3 、封装vo
        //3.1 转user的po为vo
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        //3.2 转地址vo
        if (CollUtil.isNotEmpty(addresses)){
            List<AddressVO> addressVOS = BeanUtil.copyToList(addresses, AddressVO.class);
            userVO.setAddresses(addressVOS);

        }

        return userVO;
    }

    @Override
    public List<UserVO> queryUserAndAddressByIds(List<Long> ids){
        //1.查询用户
        List<User> users = listByIds(ids);
        if (CollUtil.isEmpty(users)){
            return Collections.emptyList();
        }

        //2.查询地址
        //2.1 获取用户id集合
        List<Long> userIds = users.stream().map(User::getId).collect(Collectors.toList());

        //2.2 根据用户id查询地址
        List<Address> addresses = Db.lambdaQuery(Address.class).in(Address::getUserId, userIds).list();

        //2.3 转换地址vo
        List<AddressVO> addressVoList = BeanUtil.copyToList(addresses, AddressVO.class);
        //2.4 梳理地址集合  分类整理  相同用户的放入一个集合中
        Map<Long, List<AddressVO>> addressMap = new HashMap<>(0);
        if (CollUtil.isNotEmpty(addressVoList)) {
            addressMap = addressVoList.stream().collect(Collectors.groupingBy(AddressVO::getUserId));
        }

        //3. 转换vo返回
        List<UserVO> list = new ArrayList<>(users.size());
        for (User user:users){
            //3.1 转换user的po为vo
            UserVO vo = BeanUtil.copyProperties(user, UserVO.class);
            list.add(vo);

            //3.2 转换地址vo
            vo.setAddresses(addressMap.get(user.getId()));

        }

        return list;
    }


    //根据条件分页查询用户接口
    @Override
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {

        String name = query.getName();
        Integer status = query.getStatus();

        //1.构建分页条件
        Page<User> page = query.toMpPageDefaultSortUpdateTime();


        /*//1.1.分页条件
        Page<User> page = Page.of(query.getPageNo(), query.getPageSize());
        //1.2.排序条件
        if (StrUtil.isNotBlank(query.getSortBy())){
            page.addOrder(new OrderItem(query.getSortBy(), query.getIsAsc()));

        }else {
            //为空  默认按照创建时间排序
            page.addOrder(new OrderItem("update_time",false));
        }*/

        //2.分页条件
        Page<User> p = lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .page(page);


        //3.封装vo结果
        //return PageDTO.of(p, user -> BeanUtil.copyProperties(user,UserVO.class));
        return PageDTO.of(p, user ->{
            //1.拷贝基础属性
                    UserVO vo = BeanUtil.copyProperties(user, UserVO.class);

                    //2.处理特殊逻辑
                    vo.setUsername(vo.getUsername().substring(0,vo.getUsername().length()-2)+"**");

                    return vo;
        });


        /*PageDTO<UserVO> dto = new PageDTO<>();
        //3.1总条数
        dto.setTotal(p.getTotal());
        //3.2总页数
        dto.setPages(p.getPages());
        //3.3当前页数据
        List<User> records = p.getRecords();
        if (CollUtil.isEmpty(records)){
            dto.setList(Collections.emptyList());
            return dto;
        }

        //3.4拷贝user的vo
        List<UserVO> vos = BeanUtil.copyToList(records, UserVO.class);
        dto.setList(vos);

        //4.返回
        return dto;*/
    }



}
