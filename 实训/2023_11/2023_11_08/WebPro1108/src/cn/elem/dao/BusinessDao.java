package cn.elem.dao;

import cn.elem.bean.Business;
import cn.elem.query.PageQuery;
import cn.elem.vo.PageBean;

import java.util.List;

public interface BusinessDao extends BaseDao<Business>{
    //分页查询  参数待定
    /*
    分页条件
    currentPage  当前页
    pageNumber 每页显示的记录数
     */
    /*
    条件：PageQuery
    currentPage pageNumber

    返回：PageBean
        data  当前页数据集合  List<T>
        totalRows  总记录数  需要查询数据库
        totalPages 总页数  计算  totalRows/pageNumber  判断是否可以整除

     */
    PageBean<Business> getByPage(PageQuery pageQuery);

    Business getByAccount(String businessAccount);

}
