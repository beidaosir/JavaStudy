package com.hnu.test;

import com.hnu.po.User;
import com.hnu.query.UserQuery;
import com.hnu.service.UserService;
import com.hnu.vo.PageBean;
import com.hnu.vo.ResponseObj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetByPage(){
        UserQuery userQuery = new UserQuery();
        ResponseObj responseObj = userService.getByPgae(userQuery);
        PageBean<User> data = (PageBean<User>)responseObj.getData();
        System.out.println(data.getTotalRows());
        System.out.println(data.getData());

    }

    @Test
    public void testLoginByPhone(){
        ResponseObj responseObj = userService.loginByPhone("13788889999", "1234");
        System.out.println(responseObj.getCode());
        System.out.println(responseObj.getMsg());
        System.out.println(responseObj.getData());

    }

}