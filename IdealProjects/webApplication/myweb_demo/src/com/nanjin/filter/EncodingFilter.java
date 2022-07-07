package com.nanjin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter
/*
设置所有字符
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      //转换请求和响应对象指定为http
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

      //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;UTF-8");

      //用过滤器对象放行
        filterChain.doFilter(request,response);



    }

    @Override
    public void destroy() {

    }
}
