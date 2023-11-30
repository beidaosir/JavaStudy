<%--
  Created by IntelliJ IDEA.
  User: 克里斯
  Date: 2023/11/9
  Time: 16:43
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
<h1>添加商家信息</h1>
<form action="/business/add" method="post">
    <div class="form-group row">
        <label for="account" class="col-sm-2 col-form-label">商家账号</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="account" name="businessAccount">
        </div>
    </div>
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">商家名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="businessName">
        </div>
    </div>
    <div class="form-group row">
        <label for="address" class="col-sm-2 col-form-label">商家地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="address" name="businessAddress">
        </div>
    </div>
    <div class="form-group row">
        <label for="info" class="col-sm-2 col-form-label">商家简介</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="info" name="businessExplain">
        </div>
    </div>
    <div class="form-group row">
        <label for="startprice" class="col-sm-2 col-form-label">商家起送价</label>
        <div class="col-sm-10">
            <input type="number" class="form-control" id="startprice" name="startPrice">
        </div>
    </div>
    <div class="form-group row">
        <label for="sendprice" class="col-sm-2 col-form-label">商家配送费</label>
        <div class="col-sm-10">
            <input type="number" class="form-control" id="sendprice" name="deliveryPrice">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <input type="submit" class="form-control" value="确认添加">
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