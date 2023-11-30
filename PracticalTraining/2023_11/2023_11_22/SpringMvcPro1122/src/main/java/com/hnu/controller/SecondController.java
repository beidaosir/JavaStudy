package com.hnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 普通类+注解
 * 无需实现接口 (推荐的方式)
 */
@Controller   // 相当于bean标签
public class SecondController {

    @RequestMapping("/add")
    public ModelAndView add(){
        System.out.println("----SecondController----add----");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","我是SecondController中的add方法");
        modelAndView.setViewName("/WEB-INF/success.jsp");
        return modelAndView;
    }

}
