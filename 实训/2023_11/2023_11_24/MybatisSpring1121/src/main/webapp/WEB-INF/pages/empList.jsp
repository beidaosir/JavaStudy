<%--
  Created by IntelliJ IDEA.
  User: 克里斯
  Date: 2023/11/25
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>员工信息表</h1>


<table>
    <tr>
        <th>序号</th><th>员工编号</th><th>员工姓名</th><th>职位</th><th>工资</th><th>入职日期</th><th>操作</th>
    </tr>
    <c:forEach items="${list}" var="emp" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.job}</td>
            <td>${emp.sal}</td>
            <td>${emp.hiredate}</td>
            <td>
                <a href="/emp/findById/${emp.empno}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/emp/del/${emp.empno}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
