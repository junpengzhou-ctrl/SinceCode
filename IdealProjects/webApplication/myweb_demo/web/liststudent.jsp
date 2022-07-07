<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nanjin.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2021/1/23
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看学生</title>
</head>
<body>

<table width="80%" border="1px" align="center">
    <tr>
        <th>学生学号</th>
        <th>学生姓名</th>
        <th>学生年龄</th>
        <th>学生成绩</th>
    </tr>
    <%
        ArrayList<Student> students = (ArrayList<Student>)request.getSession().getAttribute("student");
        for (Student stu:students){
    %>
    <tr align="center">
        <td><%=stu.getId()%></td>
        <td><%=stu.getUsername()%></td>
        <td><%=stu.getAge()%></td>
        <td><%=stu.getScore()%></td>
    </tr>
    <% } %>
</table>

</body>
</html>
