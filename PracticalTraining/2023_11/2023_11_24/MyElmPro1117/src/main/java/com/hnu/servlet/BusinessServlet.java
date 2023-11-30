package com.hnu.servlet;

import com.hnu.po.Business;
import com.hnu.query.BusinessQuery;
import com.hnu.service.BusinessService;
import com.hnu.service.impl.BusinessServiceImpl;
import com.hnu.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
请求路径后面带一个参数表示要执行哪个业务
/business?what=add
...
 */

/*
使用另一种方式
/business/add
 */

//@WebServlet(urlPatterns = "/business/*")
public class BusinessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建service层的实例
        BusinessService businessService = new BusinessServiceImpl();

        //针对请求和响应做初始设置
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String requestURI = req.getRequestURI();
        //System.out.println(requestURI);

        //先找最后一个元素的下标
        int index = requestURI.lastIndexOf("/");
        String what = requestURI.substring(index + 1);

        System.out.println(what);
        if ("add".equals(what)){
            System.out.println("执行添加操作");

            String businessAccount = req.getParameter("businessAccount");
            String businessName = req.getParameter("businessName");
            String businessAddress = req.getParameter("businessAddress");
            String businessExplain = req.getParameter("businessExplain");
            String startPrice = req.getParameter("startPrice");
            String deliveryPrice = req.getParameter("deliveryPrice");

            Business business = new Business(null,businessAccount,"111111",businessName,businessAddress,businessExplain,Double.parseDouble(startPrice),Double.parseDouble(deliveryPrice),"business");
            boolean add = businessService.add(business);
            if (add){
                //添加成功之后重新查询进入到列表页面  也就是重新访问business/list
                //重定向  类似超链接
                resp.sendRedirect("/business/list");
            }else{
                resp.getWriter().write("<p>添加失败，请重试<a href='/businessAdd.jsp'>添加页面</a></p>");
            }


        }else if ("update".equals(what)){
            System.out.println("执行修改操作");

            String bid = req.getParameter("bid");
            String businessAccount = req.getParameter("businessAccount");
            String businessName = req.getParameter("businessName");
            String businessAddress = req.getParameter("businessAddress");
            String businessExplain = req.getParameter("businessExplain");
            String startPrice = req.getParameter("startPrice");
            String deliveryPrice = req.getParameter("deliveryPrice");

            Business business =
                    new Business(Integer.parseInt(bid),businessAccount,null,
                            businessName,businessAddress,businessExplain,
                            Double.parseDouble(startPrice),Double.parseDouble(deliveryPrice),
                            null);

            boolean update = businessService.update(business);

            if (update){
                resp.sendRedirect("/business/list");
            }else{
                resp.getWriter().write("<p>修改失败，请重试<a href='/business/findById?bid="+bid+"'>修改页面</a></p>");
            }

        }else if ("del".equals(what)){
            System.out.println("执行删除操作");

            //获取请求参数
            String delId = req.getParameter("delId");
            //调用service层删除方法
            boolean remove = businessService.del(Integer.parseInt(delId));
            if (remove){

                resp.sendRedirect("/business/list");
            }

        }else if ("findById".equals(what)){
            System.out.println("执行通过id查询操作");

            String bid = req.getParameter("bid");

            Business business = businessService.getById(Integer.parseInt(bid));

            req.setAttribute("business",business);
            req.getRequestDispatcher("/WEB-INF/pages/businessUpdate.jsp").forward(req,resp);



        }else if ("list".equals(what)){
            System.out.println("执行分页查询操作");

            //尝试获取  如果获取到了就设置给PageQuery  如果没有就使用默认值1/5
            String currentPage = req.getParameter("currentPage");
            String pageNumber = req.getParameter("pageNumber");

            //构建条件对象实例
            BusinessQuery pageQuery = new BusinessQuery();

            //判断当前页条件不为空  转成int类型设置给条件对象
            if (currentPage != null && !"".equals(currentPage)){
                pageQuery.setCurrentPage(Integer.parseInt(currentPage));
            }

            //每页显示记录数如果不为空  转成数字设置给条件对象
            if (pageNumber != null && !"".equals(pageNumber)){
                pageQuery.setPageNumber(Integer.parseInt(pageNumber));
            }

            PageBean<Business> pageBean = businessService.getByPage(pageQuery);

            System.out.println(pageBean);
            //需要将数据传递给前端页面 businessList.jsp
            //将数据设置到共享区域  request域对象 session servletContext
            req.setAttribute("pageBean",pageBean);
            //从servlet跳转到jsp中  如果request 域中设置了数据 那么需要通过转发来跳转页面
            req.getRequestDispatcher("/WEB-INF/pages/businessList.jsp").forward(req,resp);

        }else {
            System.out.println("暂未开通该服务");
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
