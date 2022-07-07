package com.nanjin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
登录功能
获取用户登录信息 保存到会话域中，并重定向
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if (username == null || username.equals("")){
            resp.sendRedirect("/myweb_demo_war_exploded2/login.jsp");
            return;
        }
        req.getSession().setAttribute("username",username);  //key value
        resp.sendRedirect("/myweb_demo_war_exploded2/");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
