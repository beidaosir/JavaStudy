package com.hnu.controller;

import com.hnu.service.AdminService;
import com.hnu.service.BusinessService;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    AdminService adminService;

    @Autowired
    BusinessService businessService;

    @PostMapping("/in")
    public ResponseObj login(String username, String password, String role, HttpSession session){
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
            return ResponseObj.ERROR(501,"登录失败");
        }else{
            session.setAttribute("loginUser",loginUser);
            System.out.println("---------loginUser存入session---------");
            return ResponseObj.SUCCESS("登录成功");
        }
    }

    @GetMapping("/out")
    public ResponseObj logout(HttpSession session){
        session.removeAttribute("loginUser");
        return ResponseObj.SUCCESS();
    }
}