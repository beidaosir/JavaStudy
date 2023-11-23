<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>post请求</h2>
<form action="/stu/add" method="post">
    学号：<input type="text" name="stuNumber"><br>
    姓名：<input type="text" name="stuName"><br>
    年龄：<input type="number" name="age"><br>
    <input type="submit" value="确认添加">
</form>
</body>
</html>
