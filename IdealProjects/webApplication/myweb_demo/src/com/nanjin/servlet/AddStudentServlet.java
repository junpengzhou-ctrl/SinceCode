package com.nanjin.servlet;

import com.nanjin.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String score = req.getParameter("score");

        Student stu = new Student();
        stu.setId(Integer.parseInt(id));
        stu.setUsername(username);
        stu.setAge(Integer.parseInt(age));
        stu.setScore(Integer.parseInt(score));

        //保存到本地
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:stu.txt",true));
        bw.write(stu.getId()+","+stu.getUsername()+","+stu.getAge()+","+stu.getScore());
        bw.newLine();
        bw.close();

        //调用写出流在浏览器上写上保存成功，2秒后返回到主页
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("<h1>保存成功</h1><br>2秒后返回首页...");
        resp.setHeader("Refresh","2,URL=/myweb_demo_war_exploded2/");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
