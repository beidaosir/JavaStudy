package cn.elem.service;

import cn.elem.bean.Business;
import cn.elem.query.PageQuery;
import cn.elem.vo.PageBean;

import java.util.List;

//组合dao层中的方法
public interface BusinessService {

    //添加业务
    boolean add(Business business);
    //修改业务
    boolean update(Business business);
    //删除业务
    boolean remove(Integer bid);

    //根据id查询
    Business getById(Integer bid);
    //查询所有
    List<Business> getAll();
    //分页查询
    PageBean<Business> getByPage(PageQuery pageQuery);

    //批量删除
    boolean delMany(Integer[] ids);

    Business login(String account,String password);
}
