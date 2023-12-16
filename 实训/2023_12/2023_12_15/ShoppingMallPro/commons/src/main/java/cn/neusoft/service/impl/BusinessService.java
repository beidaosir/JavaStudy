package cn.neusoft.service.impl;

import cn.neusoft.mapper.BusinessMapper;
import cn.neusoft.po.Business;
import cn.neusoft.query.BusinessQuery;
import cn.neusoft.service.IBusinessService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BusinessService extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Override
    public Business login(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper<>().eq("username", username).eq("password", password);
        Business business = baseMapper.selectOne(queryWrapper);
        return business;
    }

    @Override
    public Page<Business> getByPage(BusinessQuery businessQuery) {
        QueryWrapper queryWrapper = new QueryWrapper<>()
                .eq("businessAccount", businessQuery.getBusinessAccount())
                .like("businessName", businessQuery.getBusinessName());
        Page<Business> page = new Page<>(businessQuery.getCurrent(),businessQuery.getSize());
        return baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public boolean checkAcount(String account) {
        QueryWrapper queryWrapper = new QueryWrapper<>().eq("businessAccount",account);
        boolean exists = baseMapper.exists(queryWrapper);
        return exists;
    }
}
