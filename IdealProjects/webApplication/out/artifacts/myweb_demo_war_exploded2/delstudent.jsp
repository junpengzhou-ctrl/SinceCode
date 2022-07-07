<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2021/1/23
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生</title>
</head>
<body>
<form action="/myweb_demo_war_exploded2/delStudentServlet" method="get" autocomplete="off">
    <h3>您想删除的学号是:</h3><input type="number" name="delid">
    <button type="submit">确认</button>

</form>
</body>
</html>
