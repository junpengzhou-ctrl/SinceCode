<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2021/1/23
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生功能</title>
</head>
<body>
 <form action="/myweb_demo_war_exploded2/addStudentServlet" method="get" autocomplete="off">
     学号：<input type="number" name="id"><br>
     姓名：<input type="text" name="username"><br>
     年龄：<input type="number" name="age"><br>
     成绩：<input type="number" name="score"><br>
     <button type="submit">保存</button>
 </form>

</body>
</html>
