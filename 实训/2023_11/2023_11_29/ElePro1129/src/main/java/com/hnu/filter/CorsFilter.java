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
        //设置允许跨域
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        //设置开启Cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, resp);
    }
    @Override
    public void destroy() {}
}
