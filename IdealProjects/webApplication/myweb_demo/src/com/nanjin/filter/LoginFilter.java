package com.nanjin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
检查登录页面
 */
@WebFilter(value = {"","",""})
//拦截应的增加删除修改功能
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String contextPath = filterConfig.getServletContext().getContextPath();
        System.out.println(contextPath);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //转换请求和响应对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取会话域，判断是否有登录
        Object attribute = request.getSession().getAttribute("username");
        if (attribute == null || attribute.equals("")){
            //重定向到登录页面
            response.sendRedirect("/myweb_demo_war_exploded2/login.jsp");
            return;
        }
        //否则就放行
        filterChain.doFilter(request,response);


    }

    @Override
    public void destroy() {

    }
}
