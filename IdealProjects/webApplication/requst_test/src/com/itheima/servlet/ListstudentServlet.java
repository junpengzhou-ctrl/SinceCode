package com.itheima.servlet;

import com.itheima.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/*
实现查看的功能
 */
@WebServlet("/listStudenServlet")  //映射路径
public class ListstudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取本地文件        //将读到的数据封装到学生对象中
        //        //创建集合，添加学生对象
        BufferedReader br = new BufferedReader(new FileReader("d:\\stu.txt"));
        ArrayList<Student> students  = new ArrayList<>();
        String s;
        while ((s = br.readLine())!= null){
            String[] split = s.split(",");
            Student stu  = new Student();
            stu.setName(split[0]);
            stu.setAge(Integer.parseInt(split[1]));
            stu.setScore(Integer.parseInt(split[2]));
            students.add(stu);
        }
        //遍历集合响应给浏览器
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        for (Student stu:students){
            writer.write(stu.getName()+","+stu.getAge()+","+stu.getScore());
            writer.write("<br>");  //在浏览器中写一个换行符
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
