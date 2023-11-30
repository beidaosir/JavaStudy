package com.hnu.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.vo.ResponseObj;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("*******登录拦截器**********");
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            //登录验证失败  也需要给前端一个响应对象表示登录验证失败
            ResponseObj obj = ResponseObj.ERROR(501, "未登录");
            //将ResponseObj转成json字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(obj);
            //响应对象获取输出流写出响应体
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(jsonStr);
            //不放行
            return false;
        }
        //放行
        return true;
    }
}
