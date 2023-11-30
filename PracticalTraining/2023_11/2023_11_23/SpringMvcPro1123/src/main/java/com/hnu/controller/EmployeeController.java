package com.hnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @RequestMapping("/hello")  //   /emp/hello
    public ModelAndView hello() {

        System.out.println("==EmployeeController==hello==");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","EmployeeController==hello被访问了");
        modelAndView.setViewName("/WEB-INF/pages/success.jsp");
        return modelAndView;

    }


    @RequestMapping("/add")  //   /emp/add
    public ModelAndView add(Integer empno,String ename) {

        System.out.println("==EmployeeController==add==");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","EmployeeController==add被访问了");
        modelAndView.setViewName("/WEB-INF/pages/success.jsp");
        return modelAndView;

    }

    // restful风格的传参   以后能用这种方式的方法就用它  比如 ： getById  del
    @RequestMapping("/del/{id}/{ename}")    //    /emp/del/1001    /emp/del?empno=1001
    public ModelAndView del(@PathVariable("id") Integer empno,@PathVariable("ename") String ename){

        System.out.println("删除："+empno+"   "+ename);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","删除了:"+empno+"   "+ename);
        modelAndView.setViewName("/WEB-INF/pages/success.jsp");
        return modelAndView;
    }

    @RequestMapping("/getById")
    public String getById(){
        System.out.println("----emp--getById------");
        return "success";
    }

    @RequestMapping("/getById1")
    public String getById1(){
        System.out.println("----emp--getById11111------");
        //页面转发
        //通过以下方式就不走视图解析器了
        return "forward:/WEB-INF/aaa/result.jsp";   // /WEB-INF/aaa/result.jsp
    }

    @RequestMapping("/getById2")
    public String getById2(){
        System.out.println("----emp--getById222222------");
        //要重定向
        //通过以下方式就不走视图解析器了
        return "redirect:/welcome.jsp";
    }


}
