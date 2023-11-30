package com.hnu.dao;

import java.util.List;

public interface BaseDao <T>{
    int add(T t);
    int update(T t);
    int del(Integer id);
    T getById(Integer id);
    List<T> getALl();
}
