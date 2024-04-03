package com.beidao.cloud.service;

import com.beidao.cloud.entities.Pay;

import java.util.List;

public interface PayService {
    public int add(Pay pay);
    int delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
