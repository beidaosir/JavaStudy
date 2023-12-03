package com.hnu.service;

import com.hnu.pojo.PageBean;

//员工业务规则
public interface EmpService {
    /**
     * 条件分页查询
     * @param page 页码
     * @param pageSize 每页展示记录数
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
}