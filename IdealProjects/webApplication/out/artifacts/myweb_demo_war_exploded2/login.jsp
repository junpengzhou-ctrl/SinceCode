<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2021/1/23
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请登录学生管理系统</title>
</head>
<body>
<form action="/myweb_demo_war_exploded2/loginServlet" method="get" autocomplete="off">
    姓名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <button type="submit">保存</button>
</form>
</body>
</html>
