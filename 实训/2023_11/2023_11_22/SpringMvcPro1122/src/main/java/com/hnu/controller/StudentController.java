package com.hnu.controller;

import com.hnu.po.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 普通类+注解
 * 无需实现接口 (推荐的方式)
 */
@Controller   // 相当于bean标签
@RequestMapping("/stu")
public class StudentController {

//    @RequestMapping(path = "/add",method = {RequestMethod.POST})   //类上的路径拼接上方法上的路径是最终访问的路径
    /*@PostMapping("/add")
    public ModelAndView add(){
        System.out.println("----SecondController----add----");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","我是StudentController中的add方法");
        modelAndView.setViewName("/WEB-INF/success.jsp");
        return modelAndView;
    }*/

    //@PostMapping("/add")

  /*  @RequestMapping("/add")
    public ModelAndView add(String stuNumber,String stuName,int age){
        System.out.println("----SecondController----add----");
        System.out.println("请求参数："+stuNumber+"  "+stuName+"  "+age);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","添加了："+stuNumber+"  "+stuName+"  "+age);
        modelAndView.setViewName("/WEB-INF/success.jsp");
        return modelAndView;

    }*/

    /**
     * @RequestParam("sno") 用于请求参数名称和提交的请求参数名称不一致的情况
     * 参数列表中用到基本类型都使用包装类，因为可以接收null值
     * params = {"stuNumber","stuName"}  要求这两个参数必须提交 否则会报400的错误
     *   404  找不到
     *   405  请求方式
     *   400  请求参数有问题 bad Request
     */
    @RequestMapping(path = "/add",params = {"stuNumber","stuName"})
    public ModelAndView add(String stuNumber, String stuName, Integer age){
        System.out.println("----SecondController----add----");
        System.out.println("请求参数："+stuNumber+"  "+stuName+"  "+age);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","添加了："+stuNumber+"  "+stuName+"  "+age);
        modelAndView.setViewName("/WEB-INF/success.jsp");
        return modelAndView;
    }


    @RequestMapping("/update")
    public ModelAndView update(Student student){
        System.out.println("----SecondController----update----");
        System.out.println("修改："+student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","修改了"+student);
        modelAndView.setViewName("/WEB-INF/success.jsp");
        return modelAndView;
    }

}
