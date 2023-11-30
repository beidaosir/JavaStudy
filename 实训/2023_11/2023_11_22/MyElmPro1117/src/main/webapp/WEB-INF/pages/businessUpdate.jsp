<%@ page import="com.hnu.po.Business" %><%--
  Created by IntelliJ IDEA.
  Date: 2023/11/9
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="/static/system/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="/static/system/css/font-awesome.min.css">
</head>
<body style="padding: 15px">
<h1>修改商家信息</h1>

<%
    Business business = (Business)request.getAttribute("business");
%>

<form action="/business/update" method="post">
    <input type="hidden" name="bid" value="<%=business.getBid()%>">
    <div class="form-group row">
        <label for="account" class="col-sm-2 col-form-label">商家账号</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="account" name="businessAccount"
                   value="<%=business.getBusinessAccount()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">商家名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="businessName"
                   value="<%=business.getBusinessName()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="address" class="col-sm-2 col-form-label">商家地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="address" name="businessAddress"
                   value="<%=business.getBusinessAddress()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="info" class="col-sm-2 col-form-label">商家简介</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="info" name="businessExplain"
                   value="<%=business.getBusinessExplain()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="startprice" class="col-sm-2 col-form-label">商家起送价</label>
        <div class="col-sm-10">
            <input type="number" class="form-control" id="startprice" name="startPrice"
                   value="<%=business.getStartPrice()%>">
        </div>
    </div>
    <div class="form-group row">
        <label for="sendprice" class="col-sm-2 col-form-label">商家配送费</label>
        <div class="col-sm-10">
            <input type="number" class="form-control" id="sendprice" name="deliveryPrice"
                   value="<%=business.getDeliveryPrice()%>">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <input type="submit" class="form-control" value="确认修改">
        </div>
        <div class="col-sm-4"></div>
    </div>

</form>

<!-- Essential javascripts for application to work-->
<script src="/static/system/js/jquery-3.3.1.min.js"></script>
<script src="/static/system/js/popper.min.js"></script>
<script src="/static/system/js/bootstrap.min.js"></script>
<script src="/static/system/js/main.js"></script>
</body>
</html>
