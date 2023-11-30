<%@ page import="com.hnu.vo.PageBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hnu.po.Food" %>
<%--
  Created by IntelliJ IDEA.
  User: 克里斯
  Date: 2023/11/9
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家管理页面</title>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="/static/system/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="/static/system/css/font-awesome.min.css">

</head>
<body style="padding: 15px">

    <%
        //java代码
        PageBean<Food> pageBean = (PageBean<Food>)request.getAttribute("pageBean");

        //获取集合数据
        List<Food> foodList = pageBean.getData();
    %>

<%--    <%=pageBean%>--%>


    <h1>餐品信息表</h1>
    <a href="/foodAdd.jsp"><button type="button" class="btn btn-primary">添加餐品信息</button></a>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>序号</th><th>餐品名称</th><th>简介</th><th>价格</th><th>所属商家</th><th>操作</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < foodList.size(); i++) {
                Food food = foodList.get(i);
        %>
            <tr>
                <td><%=i+1%></td>
                <td><%=food.getFoodName()%></td>
                <td><%=food.getFoodExplain()%></td>
                <td><%=food.getFoodPrice()%></td>
                <td><%=food.getBusiness().getBusinessName()%></td>

                <td>
                    <a href="/food/findById?bid=<%=food.getFoodId()%>">修改</a>
                    <a href="/food/del?delId=<%=food.getFoodId()%>">删除</a>
                </td>
            </tr>

        <%
            }
        %>
        </tbody>
    </table>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%
                Integer totalPages = pageBean.getTotalPages();
                for (int i = 1; i <= totalPages; i++) {
            %>
            <li class="page-item"><a class="page-link" href="/food/list?currentPage=<%=i%>"><%=i%></a></li>

            <%
                }
            %>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

    <!-- Essential javascripts for application to work-->
    <script src="/static/system/js/jquery-3.3.1.min.js"></script>
    <script src="/static/system/js/popper.min.js"></script>
    <script src="/static/system/js/bootstrap.min.js"></script>
    <script src="/static/system/js/main.js"></script>
</body>
</html>
