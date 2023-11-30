package com.hnu.service.impl;

import com.hnu.mapper.BusinessMapper;
import com.hnu.po.Business;
import com.hnu.query.BaseQuery;
import com.hnu.service.BusinessService;
import com.hnu.util.MybatisUtil;
import com.hnu.vo.PageBean;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {

    SqlSession session;
    BusinessMapper mapper;

    public BusinessServiceImpl(){
        session = MybatisUtil.getSession();
        mapper = session.getMapper(BusinessMapper.class);
    }

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

        try{
            int add = mapper.add(business);
            session.commit();
            return add>0;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return false;
    }

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

        try{
            int i = mapper.update(business);
            session.commit();
            return i>0;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean del(Integer id) {

        if (id==null){
            return false;
        }

        try{
            int i = mapper.del(id);
            session.commit();
            return i>0;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Business getById(Integer id) {

        if (id==null){
            return null;
        }

        try{
          return mapper.getById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Business> getAll() {
        try{
            return mapper.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
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
        try{

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

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean addBatch(List<Business> list) {

        if (list==null || list.size()==0){
            return false;
        }

        try{

            for (int i = 0;i<list.size();i++){
                Business business = list.get(i);
                int add = mapper.add(business);
                if (add<=0){
                    session.rollback();
                    return false;
                }
            }
            session.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delBatch(Integer[] ids) {

        if (ids==null || ids.length==0){
            return false;
        }

        try{

            for (int i = 0;i<ids.length;i++){
                Integer bid = ids[i];
                int del = mapper.del(bid);
                if (del<=0){
                    session.rollback();
                    return false;
                }
            }
            session.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Business login(String username, String password) {

        if (username==null || "".equals(username) || password==null || "".equals(password)){
            return null;
        }

        try {
            return mapper.getByCondition(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }
}
