package com.hnu;

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

}