package com.beidao.cloud.service.impl;

import com.beidao.cloud.entities.Pay;
import com.beidao.cloud.mapper.PayMapper;
import com.beidao.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PayServiceImpl implements PayService {

    //@Autowired 也可
    @Resource //推荐使用这个
    private PayMapper payMapper;


    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
