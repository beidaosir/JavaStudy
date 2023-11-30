package cn.elem.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 创建过滤器需要实现Filter接口  实现三个方法 init doFilter destroy
 * 继承HttpFilter 主动重写doFilter
 *
 * 需要给filter配置一个路径  表示需要拦截哪些资源
 */
@WebFilter("/*")
public class LoginFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*
        @WebFilter("/*")  拦截所有的路径
          URI：
            拦截  不确定
            不拦截   /login.jsp   /log/in   /static/xxxx   直接放行

            剩下的都拦截：
               判断session中是否存在loginUser
               有  放行
               没有   回到登录页面
         */
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
}
