<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2021/1/23
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生管理系统登录页面</title>
  </head>
  <body>
<%--  拿到会话域中username 如果为空是 说明没有登录 显示请登录连接 并连接到 登录页面--%>
<%--  如果拿到对应的username 则会查看 对应的内容--%>
<%--<%!%>这可以定义成员变量或者方法--%>
  <%  Object user = request.getSession().getAttribute("username"); %>
  <% if (user == null){ %>
  <a href="/myweb_demo_war_exploded2/login.jsp">请登录</a>
  <% } else {%>
<h1 align="center">学生信息管理系统</h1>
<div width="600px" align="center">
  <ul>
    <li><h2><a href="/myweb_demo_war_exploded2/addstudent.jsp">添加学生</a></h2></li>
    <li><h2><a href="/myweb_demo_war_exploded2/listStudentServlet">查看学生</a></h2></li>
    <li><h2><a href="/myweb_demo_war_exploded2/delstudent.jsp">删除学生</a></h2></li>
  </ul>
</div>
  <% } %>

  </body>
</html>
