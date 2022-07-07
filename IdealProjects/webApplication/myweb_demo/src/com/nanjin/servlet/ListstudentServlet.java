package com.nanjin.servlet;

import com.nanjin.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/listStudentServlet")
public class ListstudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取本地文件
        BufferedReader br = new BufferedReader(new FileReader("d:\\stu.txt"));
        ArrayList<Student> students = new ArrayList<>();
        String s;
        while ((s = br.readLine()) != null) {
            String[] stuelments = s.split(",");
            Student stu = new Student();
            stu.setId(Integer.parseInt(stuelments[0]));
            stu.setUsername(stuelments[1]);
            stu.setAge(Integer.parseInt(stuelments[2]));
            stu.setScore(Integer.parseInt(stuelments[3]));
            students.add(stu);
        }
        //将集合内容保存到会话域中
        req.getSession().setAttribute("student",students);
        //重定向
        resp.sendRedirect("/myweb_demo_war_exploded2/liststudent.jsp");
        br.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
