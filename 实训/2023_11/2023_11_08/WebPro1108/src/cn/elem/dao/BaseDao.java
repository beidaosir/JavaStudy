package cn.elem.dao;

import java.util.List;

public interface BaseDao<T> {
    //增删改
    int add(T t);
    int update(T t);
    int remove(Integer bid);

    //查询一个
    T getById(Integer bid);
    //查询所有
    List<T> getAll();
}
