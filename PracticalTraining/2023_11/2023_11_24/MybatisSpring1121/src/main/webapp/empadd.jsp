<%--
  Created by IntelliJ IDEA.
  User: 克里斯
  Date: 2023/11/25
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加员工</h1>
<form action="/emp/add" method="post">
    员工编号：<input type="number" name="empno"><br>
    员工姓名：<input type="text" name="ename"><br>
    工资收入：<input type="number" name="sal"><br>
    入职日期：<input type="date" name="hiredate"><br>
    工作岗位：<input type="text" name="job"><br>
    <input type="submit" value="确认添加">
</form>
</body>
</html>