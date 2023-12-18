package com.hnu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnu.mapper.DeptMapper;
import com.hnu.po.Dept;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class HelloApplicationTest
{

    @Autowired
    DeptMapper deptMapper;

    @Test
    public void test01(){
        List<Dept> deptList = deptMapper.selectList(null);

        deptList.forEach(System.out::println);
    }

    @Test
    public void test02(){
        Dept dept = deptMapper.selectById(10);
        System.out.println(dept);
    }

    @Test
    public void test03(){
        int insert = deptMapper.insert(new Dept(70,"销售部","新乡"));
        System.out.println(insert);

    }

    @Test
    public void test04(){
        int i = deptMapper.updateById(new Dept(70,"财务部","郑州"));
        System.out.println(i);
    }

    @Test
    public void test05(){
        int delete = deptMapper.deleteById(70);
        System.out.println(delete);
    }

    @Test
    public void test06() {
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.gt("deptno",10);
//        queryWrapper.lt("deptno",50);
//        queryWrapper.between("deptno",20,40);
//        queryWrapper.like("dname","SA");
//        queryWrapper.orderBy(true,false,"deptno");
//        queryWrapper.eq("dname","SALES");
//        queryWrapper.isNull(true,"loc");
        queryWrapper.in("deptno",20,50,30);
        //SELECT deptno,dname,loc FROM dept
        List<Dept> deptList = deptMapper.selectList(queryWrapper);
        deptList.forEach(System.out::println);
    }

    @Test
    public void test07(){
        //创建IPage对象，设置参数：第几页、每页显示最大行数
        IPage<Dept> page = new Page<>(2,5);

        IPage<Dept> deptPage = deptMapper.selectPage(page, null);

        System.out.println("当前页："+deptPage.getCurrent());
        System.out.println("每页显示："+deptPage.getSize());
        System.out.println("总记录数："+deptPage.getTotal());
        System.out.println("总页数："+deptPage.getPages());
        deptPage.getRecords().forEach(System.out::println);
    }



}