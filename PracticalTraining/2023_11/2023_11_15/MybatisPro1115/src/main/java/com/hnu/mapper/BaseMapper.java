package com.hnu.mapper;

import java.util.List;

public interface BaseMapper<T>{

    int add(T t);
    int update(T t);
    int del(Integer id);
    T getById(Integer id);
    List<T> getAll();

}
