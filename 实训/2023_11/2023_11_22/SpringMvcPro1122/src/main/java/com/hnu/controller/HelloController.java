package com.hnu.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        System.out.println("进入HelloController了");
        //接收请求参数
        //校验参数
        //调用service层处理业务
        //给出响应 数据 和 跳转页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "我是一个HelloController");
        modelAndView.setViewName("/WEB-INF/success.jsp");
        return modelAndView;
    }
}