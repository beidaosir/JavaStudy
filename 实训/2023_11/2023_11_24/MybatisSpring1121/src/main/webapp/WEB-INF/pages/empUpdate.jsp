<%--
  Created by IntelliJ IDEA.
  User: 克里斯
  Date: 2023/11/25
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改员工</h1>
<form action="/emp/update" method="post">
    员工编号：<input type="number" name="empno" value="${emp.empno}" readonly><br>
    员工姓名：<input type="text" name="ename" value="${emp.ename}"><br>
    工资收入：<input type="number" name="sal" value="${emp.sal}"><br>
    入职日期：<input type="date" name="hiredate" value="${emp.hiredate}"><br>
    工作岗位：<input type="text" name="job" value="${emp.job}"><br>
    <input type="submit" value="确认修改">
</form>
</body>
</html>