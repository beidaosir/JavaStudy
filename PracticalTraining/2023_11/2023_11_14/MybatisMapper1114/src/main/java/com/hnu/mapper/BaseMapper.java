package com.hnu.mapper;

import com.hnu.po.Employee;

import java.util.List;

public interface BaseMapper<T>{

    int add(T t);
    int update(T t);
    int del(Integer id);
    T getById(Integer id);
    List<Employee> getAll();

}
