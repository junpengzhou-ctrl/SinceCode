package com.mozhoudonglu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/test")
    public String test(Model model) {
        String student = "hehe";
        model.addAttribute("msg",student);   //msg为传给前端的标识，student为具体对象
        return "hello";  //thymeleaf调用的是模板中的html名称
    }
}
