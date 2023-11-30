package com.hnu.servlet;


import com.hnu.po.Admin;
import com.hnu.po.Business;
import com.hnu.service.AdminService;
import com.hnu.service.BusinessService;
import com.hnu.service.impl.AdminServiceImpl;
import com.hnu.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * /log/in
 * /log/out
 */
@WebServlet(urlPatterns = "/log/*")
public class LogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdminService adminService = new AdminServiceImpl();

        String requestURI = req.getRequestURI();
        String what = requestURI.substring(requestURI.lastIndexOf("/") + 1);

        if ("in".equals(what)){

            String username = req.getParameter("account");
            String password = req.getParameter("password");
            String role = req.getParameter("role");

            //管理员登录
            if ("manager".equals(role)){

                Admin login = adminService.login(username, password);
                if (login==null){
                    //登录失败  还回到登录页面
                    resp.sendRedirect("/login.jsp");
                }else{
                    /*
                    登录成功  进入主页
                    只有跳转是不行的 如果直接访问主页不经过登录页面也是可以的
                    登录成功之后应该记录登录状态
                    直接访问主页或其他资源需要进行登录验证 ： 就是查看登录状态是否存在

                    登录成功 需要将登录成功的用户信息存储起来  还要让其他的资源可以访问到 所以需要进行数据共享
                    request域行不行  否定  因为使用request必须从login.jsp转发到index.jsp
                    很多情况下我们完成登录之后就要直接刷新主页面
                    session域  会话对象
                    使用session存储登录成功的信息
                     */
                    HttpSession session = req.getSession();
                    session.setAttribute("loginUser",login);
                    System.out.println("---------loginUser存入session---------");
                    resp.sendRedirect("/index.jsp");
                }

            }else if("business".equals(role)){
                System.out.println("---商家登录---");
                BusinessService businessService = new BusinessServiceImpl();
                Business loginUser = businessService.login(username,password);

                if (loginUser==null){
                    resp.sendRedirect("/login.jsp");
                    return;
                }
                HttpSession session = req.getSession();
                session.setAttribute("loginUser",loginUser);
                System.out.println("---------loginUser存入session---------");
                resp.sendRedirect("/index.jsp");
            }


        }else if("out".equals(what)){
            //从session中移除loginUser 或者直接销毁session
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
