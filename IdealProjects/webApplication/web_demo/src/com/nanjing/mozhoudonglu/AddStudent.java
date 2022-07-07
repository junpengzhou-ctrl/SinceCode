package com.nanjing.mozhoudonglu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受客户端提交的信息
        String stuname = req.getParameter("stuname");    //这边的参数就是form表单中的name名称
        String age = req.getParameter("age");
        String score = req.getParameter("score");

        //将信息写到本地
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                "D:\\IdealProjects\\webApplication\\web_demo\\resource\\addStu.txt",true));
        //创建的路径最后文件名称一定是不存在的，写入的时候自动创建
        bw.write(stuname+"---"+age+"---"+score);
        bw.newLine();  //换行
        bw.close();

        //返回保存后的结果
        PrintWriter writer = resp.getWriter();
        writer.println("Save Success!");
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
