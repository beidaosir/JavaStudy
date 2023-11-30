package com.hnu.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse resp = (HttpServletResponse)response;
        //1、获取uri
        HttpServletRequest req = (HttpServletRequest)request;
        String requestURI = req.getRequestURI();
        System.out.println("进入过滤器----："+requestURI);


        //以下不拦截
        if("/login.jsp".equals(requestURI) || "/log/in".equals(requestURI) || requestURI.contains("/static")){
            //放行
            chain.doFilter(req,resp);
            return;
        }

        //2、判断是否登录
        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser==null){
            //没有登录 回到登录页面
            resp.sendRedirect("/login.jsp");
            return;
        }

        //说明登录过了  放行
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }


}
