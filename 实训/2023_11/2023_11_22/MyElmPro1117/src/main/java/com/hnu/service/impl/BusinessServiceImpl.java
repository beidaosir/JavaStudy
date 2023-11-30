package com.hnu.service.impl;

import com.hnu.mapper.BusinessMapper;
import com.hnu.po.Business;
import com.hnu.query.BaseQuery;
import com.hnu.service.BusinessService;
import com.hnu.vo.PageBean;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper mapper;


    @Transactional
    @Override
    public boolean add(Business business) {

        if (business==null){
            return false;
        }

        if (business.getBusinessAccount()==null || "".equals(business.getBusinessAccount())){
            return false;
        }

        if (business.getBusinessName()==null || "".equals(business.getBusinessName())){
            return false;
        }

        return mapper.add(business)>0;
    }

    @Transactional
    @Override
    public boolean update(Business business) {

        if (business==null){
            return false;
        }

        if (business.getBid()==null){
            return false;
        }

        if (business.getBusinessAccount()==null || "".equals(business.getBusinessAccount())){
            return false;
        }

        if (business.getBusinessName()==null || "".equals(business.getBusinessName())){
            return false;
        }

        return mapper.update(business)>0;
    }

    @Transactional
    @Override
    public boolean del(Integer id) {

        if (id==null){
            return false;
        }

        return mapper.del(id)>0;
    }

    @Override
    public Business getById(Integer id) {

        if (id==null){
            return null;
        }

        return mapper.getById(id);
    }

    @Override
    public List<Business> getAll() {
        return mapper.getAll();
    }

    @Override
    public PageBean<Business> getByPage(BaseQuery baseQuery) {

        if (baseQuery==null){
            return null;
        }

        if (baseQuery.getCurrentPage()==null){
            baseQuery.setCurrentPage(1);
        }

        if (baseQuery.getPageNumber()==null){
            baseQuery.setPageNumber(5);
        }

        PageBean<Business> pageBean = new PageBean<>();
        //1、查询总记录
        int totalRows = mapper.getCount(baseQuery);
        pageBean.setTotalRows(totalRows);

        //2、计算总页数
        int totalPages = totalRows%baseQuery.getPageNumber()==0?totalRows/baseQuery.getPageNumber():totalRows/baseQuery.getPageNumber()+1;
        pageBean.setTotalPages(totalPages);

        //3、查询当前页的集合
        List<Business> data = mapper.getByPage(baseQuery);
        pageBean.setData(data);

        return pageBean;
    }

    @Transactional
    @Override
    public boolean addBatch(List<Business> list) throws Exception {

        if (list==null || list.size()==0){
            return false;
        }

        for (int i = 0;i<list.size();i++){
            Business business = list.get(i);
            int add = mapper.add(business);
            if (add<=0){
                throw new Exception("添加中断"); //抛出异常
            }
        }
        return true;
    }

    @Transactional
    @Override
    public boolean delBatch(Integer[] ids) throws Exception {

        if (ids==null || ids.length==0){
            return false;
        }

        for (int i = 0;i<ids.length;i++){
            Integer bid = ids[i];
            int del = mapper.del(bid);
            if (del<=0){
                throw new Exception("删除中断"); //抛出异常
            }
        }
        return true;
    }

    @Override
    public Business login(String username, String password) {

        if (username==null || "".equals(username) || password==null || "".equals(password)){
            return null;
        }

        return mapper.getByCondition(username, password);

    }
}
