package com.baifute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller

public class LoginController {
    @RequestMapping("/user/login")  //浏览器输入的
    //根据网页上传过来的用户输入的用户名，密码，RequestParam的内容和页面的 input标签中属性name 内容一直
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {//回显数据用model
       //具体业务
        if (null!=username &&password.equals("123456")){
            session.setAttribute("loginuser",username);   //登录成功后有自己的会话空间，如果没有就被拦截器拦下
            return "redirect:/main.html";    //登录成功后应该重定向 这样可以隐藏 请求的参数
        }else
        {
            model.addAttribute("msg","用户名或者密码错误")  ;
                             //页面拿到msg ，如果账号密码符合要求msg 就是空，如果是空就不显示，否则就上一行的内容
                             //对应前端代码为 th:text="${msg} th:if="${not #strings.isEmpty(msg)}" 不为空就显示内容
            return "index";
        }

    }
}
