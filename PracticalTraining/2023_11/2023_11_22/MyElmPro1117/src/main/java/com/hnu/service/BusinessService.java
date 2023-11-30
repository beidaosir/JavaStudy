package com.hnu.service;

import com.hnu.po.Business;

public interface BusinessService extends BaseService<Business>{

//    boolean add(Business t);
//    boolean update(Business t);
//    boolean del(Integer id);
//
//    Business getById(Integer id);
//    List<Business> getAll();
//
//    PageBean<Business> getByPage(BaseQuery baseQuery);
//    boolean addBatch(List<Business> list);
//    boolean delBatch(Integer[] ids);

    Business login(String username,String password) ;
}