package com.hnu.mapper;

import com.hnu.po.Business;
import org.apache.ibatis.annotations.Param;

public interface BusinessMapper extends BaseMapper<Business>,PageMapper<Business>{

//    int add(Business t);
//    int update(Business t);
//    int del(Integer id);
//    Business getById(Integer id);
//    List<Business> getAll();
//    int getCount(BaseQuery baseQuery);
//    List<Business> getByPage(BaseQuery baseQuery);

    Business getByCondition(@Param("businessAccount") String username,@Param("password") String password);

}