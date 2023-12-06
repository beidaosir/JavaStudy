package com.hnu.servlet;


import com.hnu.po.Admin;
import com.hnu.po.Business;
import com.hnu.service.AdminService;
import com.hnu.service.BusinessService;
import com.hnu.service.impl.AdminServiceImpl;
import com.hnu.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * /log/in
 * /log/out
 */
//@WebServlet(urlPatterns = "/log/*")
public class LogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdminService adminService = new AdminServiceImpl();
        BusinessService businessService = new BusinessServiceImpl();

        String requestURI = req.getRequestURI();
        String what = requestURI.substring(requestURI.lastIndexOf("/") + 1);

        if ("in".equals(what)){

            String username = req.getParameter("account");
            String password = req.getParameter("password");
            String role = req.getParameter("role");

            //设置一个登录用户  可能是管理员 也可能是商家
            Object loginUser = null;
            //管理员登录
            if ("manager".equals(role)){
                loginUser = adminService.login(username, password);
            }else if("business".equals(role)){
                loginUser = businessService.login(username, password);
            }

            if (loginUser == null){
                resp.sendRedirect("/login.jsp");

            }else{

                String remember = req.getParameter("remember");
                System.out.println("remember:"+remember);

                if (remember!=null){
                    Cookie namecookie = new Cookie("username",username);
                    Cookie passwordcookie = new Cookie("password",password);
                    resp.addCookie(namecookie);
                    resp.addCookie(passwordcookie);
                }

                HttpSession session = req.getSession();
                session.setAttribute("loginUser",loginUser);
                System.out.println("---------loginUser存入session---------");
                resp.sendRedirect("/index.jsp");
            }


        }else if("out".equals(what)){

            //从session中移除loginUser  或者  直接销毁session
            HttpSession session = req.getSession();
            session.removeAttribute("loginUser");
            //跳转到登录页面
            resp.sendRedirect("/login.jsp");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
