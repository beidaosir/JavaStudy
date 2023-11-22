package com.beidao;

import com.beidao.mapper.EmpMapper;
import com.beidao.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MyPro1116ApplicationTests {

    @Autowired //将这个接口对象注入进来
    private EmpMapper empMapper;

    @Test
    public void testDelete(){
        int delete = empMapper.delete(17);
        System.out.println(delete);
    }

    @Test
    public void testInsert(){
        //创建员工对象
        Emp emp = new Emp();
        emp.setUsername("jack2");
        emp.setName("杰克2");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //调用添加方法
        empMapper.insert(emp);

        System.out.println(emp.getId());
    }


    @Test
    public void testUpdate(){
        //要修改的员工信息
        Emp emp = new Emp();
        emp.setId(20);
        emp.setUsername("songdaxia");
        emp.setPassword(null);
        emp.setName("老宋");
        emp.setImage("2.jpg");
        emp.setGender((short)1);
        emp.setJob((short)2);
        emp.setEntrydate(LocalDate.of(2012,1,1));
        emp.setCreateTime(null);
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);
        //调用方法，修改员工数据
        empMapper.update(emp);
    }

    //根据id查询
    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(1);
        System.out.println(emp);
    }

    //根据条件查询员工
    @Test
    public void testList(){
        //List<Emp> list = empMapper.list("张", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        //List<Emp> list = empMapper.list("张", null, null, null);
        List<Emp> list = empMapper.list(null, null, null, null);
        for(Emp emp : list){
            System.out.println(emp);
        }

    }

    @Test
    public void testUpdate2(){
        //要修改的员工信息
        Emp emp = new Emp();
        emp.setId(20);
        emp.setUsername("Tom111");
        emp.setGender((short)1);
        emp.setName("汤姆111");

        emp.setUpdateTime(LocalDateTime.now());

        //调用方法，修改员工数据
        empMapper.update2(emp);
    }


    @Test
    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(18,19,20);
        empMapper.deleteByIds(ids);
    }

}
