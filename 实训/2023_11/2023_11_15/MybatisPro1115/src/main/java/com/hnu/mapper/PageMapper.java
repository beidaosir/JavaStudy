package com.hnu.mapper;

import com.hnu.query.BaseQuery;

import java.util.List;

public interface PageMapper<T>{

    /*
    统计也需要根据分页相同的条件来进行统计
     */
    int getCount(BaseQuery baseQuery);
    /*
    分页的同时也需要搜索
    传递的条件对象 query里面需要包含 分页的条件  currentPage  pageNumber  每个模块都一样
                                搜索的条件  根据业务来定  businessName  businessAccount  不同的模块不一样
     */
    List<T> getByPage(BaseQuery baseQuery);

}