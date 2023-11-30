package com.hnu.service;

import com.hnu.query.BaseQuery;
import com.hnu.vo.PageBean;

import java.util.List;

public interface BaseService<T>{

    boolean add(T t);
    boolean update(T t);
    boolean del(Integer id);

    T getById(Integer id);
    List<T> getAll();

    PageBean<T> getByPage(BaseQuery baseQuery);
    boolean addBatch(List<T> list);
    boolean delBatch(Integer[] ids);
}
