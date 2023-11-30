package cn.elem.test;

import cn.elem.bean.Business;
import cn.elem.dao.BusinessDao;
import cn.elem.dao.impl.BusinessDaoImpl;
import cn.elem.query.PageQuery;
import cn.elem.vo.PageBean;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BusinessDaoTest {

    BusinessDao businessDao;

    @Before
    public void before(){
        businessDao = new BusinessDaoImpl();
    }

    @Test
    public void testAdd(){
        //测试添加
        Business business = new Business(null,"321673","111111","美味小吃","新乡","好吃",15.0,4.0,"business");
        int add = businessDao.add(business);
        System.out.println(add);
    }

    @Test
    public void testUpdate(){
        Business business = new Business(10003,"333333","111111","沙县小吃","新乡","好吃实惠",18.0,8.0,"business");
        int update = businessDao.update(business);
        System.out.println(update);
    }

    @Test
    public void testRemove(){
        //测试删除
        int remove = businessDao.remove(10003);
        System.out.println(remove);
    }


    @Test
    public void testFindById(){
        Business business = businessDao.getById(10002);
        System.out.println(business);
    }


    @Test
    public void testFindAll(){
        List<Business> all = businessDao.getAll();
        System.out.println(all);
    }

    @Test
    public void testFindByPage(){
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCurrentPage(2);
        PageBean<Business> pageBean = businessDao.getByPage(pageQuery);
        System.out.println("总记录数："+pageBean.getTotalRows());
        System.out.println("总页数："+pageBean.getTotalPages());
        List<Business> businessList = pageBean.getData();
        System.out.println("当前页的集合长度："+businessList.size());

        for (Business business:businessList){
            System.out.println(business);
        }
    }

}
