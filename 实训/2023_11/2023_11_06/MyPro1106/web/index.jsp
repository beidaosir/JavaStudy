<%--
  Created by IntelliJ IDEA.
  User: 克里斯
  Date: 2023/11/6
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>hello</title>
</head>
<body>
<h1 style="color: red">Hello Tomcat</h1>
<%
  String name = "zhangsan";
  System.out.println(name);
%>

<%=name%>

<h2>提交表单测试post请求体</h2>
<form action="/MyPro1106_war_exploded/hello" method="get">
  <input type="text" name="username" value="zhangsan"><br>
  <input type="password" name="password" value="123456"><br>
  <input type="submit" value="确认提交">
</form>


</body>
</html>
