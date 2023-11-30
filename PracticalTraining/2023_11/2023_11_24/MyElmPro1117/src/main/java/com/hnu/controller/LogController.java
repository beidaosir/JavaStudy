package com.hnu.controller;

import com.hnu.service.AdminService;
import com.hnu.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    AdminService adminService;

    @Autowired
    BusinessService businessService;

    @RequestMapping("/in")
    public String login(String username,String password,String role,HttpSession session){
        System.out.println(username+"   "+password+"  "+role);
        //设置一个登录用户  可能是管理员 也可能是商家
        Object loginUser = null;
        //管理员登录
        if ("manager".equals(role)){
            loginUser = adminService.login(username, password);
        }else if("business".equals(role)){
            loginUser = businessService.login(username, password);
        }

        System.out.println("**********登录完成*************"+loginUser);

        if (loginUser == null){
            return "redirect:/login.jsp";
        }else{
            session.setAttribute("loginUser",loginUser);
            System.out.println("---------loginUser存入session---------");
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping("/out")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:/login.jsp";
    }
}
