package com.hnu.service.impl;

import com.hnu.mapper.BusinessMapper;
import com.hnu.po.Business;
import com.hnu.query.BaseQuery;
import com.hnu.service.BusinessService;
import com.hnu.vo.PageBean;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper mapper;

    @Transactional(propagation = Propagation.REQUIRED)
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

        if (!checkAcount(business.getBusinessAccount())){
            return false;
        }

        //设置默认密码
        business.setPassword("111111");
        //设置默认角色
        business.setRole("business");

        return mapper.add(business)>0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
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

    @Transactional(readOnly = true)
    @Override
    public Business getById(Integer id) {

        if (id==null){
            return null;
        }

        return mapper.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Business> getAll() {
        return mapper.getAll();
    }

    @Transactional(readOnly = true)
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
                throw new Exception("添加中断");
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
                throw new Exception("删除中断");
            }
        }
        return true;
    }

    @Override
    public Business login(String username, String password) {

        if (username==null || "".equals(username) || password==null || "".equals(password)){
            return null;
        }

        return mapper.getByCondition(username,password);
    }

    /**
     * 如果通过账号没有查到相关的商家名称 说明账号不存在 可以使用 返回true  反之为false
     * @param account
     * @return
     */
    @Override
    public boolean checkAcount(String account) {
        String name = mapper.getByAccount(account);
        return name==null || "".equals(name);
    }
}