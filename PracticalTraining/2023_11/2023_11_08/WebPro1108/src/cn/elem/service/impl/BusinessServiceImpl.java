package cn.elem.service.impl;

import cn.elem.bean.Business;
import cn.elem.dao.BusinessDao;
import cn.elem.dao.impl.BusinessDaoImpl;
import cn.elem.query.PageQuery;
import cn.elem.service.BusinessService;
import cn.elem.vo.PageBean;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {

    //声明一个dao层的对象 service层依赖dao层进行数据处理
    BusinessDao businessDao;

    public BusinessServiceImpl(){
        businessDao = new BusinessDaoImpl();
    }

    @Override
    public boolean add(Business business) {

        //判断参数是否有效
        if(business==null){
            return false;
        }

        //判断账号是否为空
        if(business.getBusinessAccount()==null || "".equals(business.getBusinessAccount())){
            return false;
        }

        //判断商家名称是否为空
        if (business.getBusinessName()==null || "".equals(business.getBusinessName())){
            return false;
        }
        //判断账号是否重复
        Business bus = businessDao.getByAccount(business.getBusinessAccount());
        if (bus!=null){
            return false;
        }


        int add = businessDao.add(business);
        return add>0;
    }

    @Override
    public boolean update(Business business) {
        //判断参数是否有效
        if(business==null){
            return false;
        }

        //判断主键是否为空
        if (business.getBid()==null){
            return false;
        }

        //判断账号是否为空
        if(business.getBusinessAccount()==null || "".equals(business.getBusinessAccount())){
            return false;
        }

        //判断商家名称是否为空
        if (business.getBusinessName()==null || "".equals(business.getBusinessName())){
            return false;
        }


        int update = businessDao.update(business);

        return update>0;
    }

    @Override
    public boolean remove(Integer bid) {

        if (bid==null){
            return false;
        }

        int remove = businessDao.remove(bid);

        return remove>0;
    }

    @Override
    public Business getById(Integer bid) {

        if (bid==null){
            return null;
        }

        return businessDao.getById(bid);
    }

    @Override
    public List<Business> getAll() {
        return businessDao.getAll();
    }

    @Override
    public PageBean<Business> getByPage(PageQuery pageQuery) {

        if(pageQuery==null || pageQuery.getCurrentPage()==null || pageQuery.getPageNumber()==null){
            return null;
        }

        return businessDao.getByPage(pageQuery);
    }

    @Override
    public boolean delMany(Integer[] ids) {

        if (ids==null || ids.length==0){
            return false;
        }

        for (Integer delId : ids) {
            businessDao.remove(delId);
        }
        return true;
    }

    @Override
    public Business login(String account, String password) {
        if (account==null || "".equals(account) || password==null || "".equals(password)){
            return null;
        }

        Business business = businessDao.getByAccount(account);

        if (business!=null && business.getPassword().equals(password)){
            //登录成功
            return business;
        }
        return null;
    }
}
