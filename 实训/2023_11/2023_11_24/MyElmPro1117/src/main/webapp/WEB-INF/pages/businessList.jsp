<%@ page import="com.hnu.vo.PageBean" %>
<%@ page import="com.hnu.po.Business" %>
<%@ page import="java.util.List" %>
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
        PageBean<Business> pageBean = (PageBean<Business>)request.getAttribute("pageBean");

        //获取集合数据
        List<Business> businessList = pageBean.getData();
    %>

<%--    <%=pageBean%>--%>


    <h1>商家信息表</h1>
    <a href="/businessAdd.jsp"><button type="button" class="btn btn-primary">添加商家信息</button></a>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>序号</th><th>账号</th><th>密码</th><th>商家名称</th><th>商家地址</th><th>商家简介</th><th>起送费</th><th>配送费</th><th>操作</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < businessList.size(); i++) {
                Business business = businessList.get(i);
        %>
            <tr>
                <td><%=i+1%></td>
                <td><%=business.getBusinessAccount()%></td>
                <td><%=business.getPassword()%></td>
                <td><%=business.getBusinessName()%></td>
                <td><%=business.getBusinessAddress()%></td>
                <td><%=business.getBusinessExplain()%></td>
                <td><%=business.getStartPrice()%></td>
                <td><%=business.getDeliveryPrice()%></td>
                <td>
                    <a href="/business/findById/<%=business.getBid()%>">修改</a>
                    <a href="/business/del/<%=business.getBid()%>">删除</a>
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
            <li class="page-item"><a class="page-link" href="/business/list?currentPage=<%=i%>"><%=i%></a></li>

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
