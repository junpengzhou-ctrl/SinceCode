package com.baifute.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器功能  return true 放行，return false 不放行
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功后应该有自己的用户Session
        Object loginuser = request.getSession().getAttribute("loginuser");//获取用户的session 信息
        if (null==loginuser){
          request.setAttribute("msg","没有权限请先登录！");
          request.getRequestDispatcher("/index.html").forward(request,response);     //跳转到index页面
            return false;     //return false 不放行
        }else {
            return true;
        }
    }

}
