package com.itheima.servlet;

import com.itheima.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
实现添加功能
 */
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单中的数据
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String score = req.getParameter("score");

        //创建学生对象，并赋值
        Student stu = new Student();
        stu.setName(username);
        stu.setAge(Integer.parseInt(age));
        stu.setScore(Integer.parseInt(score));

        //将学生对象的数据保存在本地
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\stu.txt",true));  //追加模式
        bw.write(stu.getName()+","+stu.getAge()+","+stu.getScore());
        bw.newLine();
        bw.close();

        //通过定时刷新的功能响应给浏览器
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("添加成功。2秒后自动跳转到首页");
        resp.setHeader("Refresh","2,URL=/requst_test_war_exploded/");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
