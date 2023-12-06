package com.hnu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        System.out.println("进入跨域过滤器");
        //设置允许跨域
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        //设置开启Cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 设置允许跨域请求的域
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        // 如果是OPTIONS请求，则直接返回
        if("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // 如果请求合法，则将请求继续传递
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {}
}