package com.hnu.servlet;

import com.alibaba.fastjson.JSON;
import com.hnu.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class HelloServlet extends HttpServlet {

    //如果get 和 post使用一个方法处理的话 可以合二为一
    //重写doGet  处理get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----HelloServlet被访问了-----------");
        //request 封装了请求信息

        System.out.println("----------------请求行-----------------------");
        String method = req.getMethod();
        System.out.println("请求方式："+method);
        String requestURI = req.getRequestURI();
        System.out.println("URI："+requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("URL："+requestURL);

        String protocol = req.getProtocol();
        System.out.println("协议："+protocol);

        System.out.println("----------------请求头-----------------------");
//        String accept = req.getHeader("Accept");
//        System.out.println("Accept："+accept);

        /*
        Enumeration用法参照迭代器  Iterator
         */
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            System.out.println(key+":"+value);
        }

        /*
        请求参数【必须掌握】
        get请求无需处理中文乱码
        post请求必须处理中文乱码
        req.setCharacterEncoding("UTF-8");
        String value = req.getParameter(key);

         */
        req.setCharacterEncoding("UTF-8");
        System.out.println("------------请求参数------------------");
        System.out.println("------地址栏携带的参数----不需要处理中文乱码  服务器已经处理过了--");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println(name+"  "+age);
        System.out.println("------请求体也可以携带参数 只有post请求才能发送请求体-------------");
        System.out.println("------需要通过表单提交来进行测试---在index.jsp上编写一个表单 提交到servlet中即可-------");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+"  "+password);

        //response 封装了响应信息
        //给页面输出内容
        //resp.getWriter().write("<h1 style='color:red'>hello I'm HelloServlet</h1>");

/*
        设置允许跨域请求
        * 通配符  全部允许
         */
        resp.setHeader("Access-Control-Allow-Origin","*");
        
        resp.setContentType("application/json;charset=UTF-8");

        List<User> userList = new ArrayList<>();
        Collections.addAll(userList,
                new User(1001,"zhangsan","123456","manager"),
                new User(1002,"admin","123456","manager"),
                new User(1003,"wangwu","123456","business"));

        String jsonString = JSON.toJSONString(userList);

        resp.getWriter().write(jsonString);

    }

    //重写doPost  处理post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}