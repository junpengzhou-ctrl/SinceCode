package com.nanjin.servlet;

import com.nanjin.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/*
  删除学生
 */
@WebServlet("/delStudentServlet")
public class DelStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delid = req.getParameter("delid");

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
        int oldsize = students.size();

      //  resp.setContentType("text/html;charset=UTF-8");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student next = iterator.next();
            if (next.getId() == Integer.parseInt(delid)){
                iterator.remove();
            }
        }
        int newsize = students.size();
        //把现在的集合中的学生对象写到stu.txt
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\stu.txt"));
        for (Student stu: students){
            bw.write(stu.getId()+","+stu.getUsername()+","+stu.getAge()+","+stu.getScore());
            bw.newLine();
        }


        //如果现在集合中的学生数量小于原本查看的学生数量则表示删除成功，否则就表示没有删除成功
        if (newsize < oldsize){
            resp.getWriter().write("删除成功啦，2秒后跳转首页...");
            resp.setHeader("Refresh","2,URL=/myweb_demo_war_exploded2/");
        }else {

        resp.getWriter().write("没找到该ID，请查看确认后再删除!!!");
        resp.setHeader("Refresh","5,URL=/myweb_demo_war_exploded2/");

        }


        bw.close();
        br.close();




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
