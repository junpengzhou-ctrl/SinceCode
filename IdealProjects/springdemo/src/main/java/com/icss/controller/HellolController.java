package com.icss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//在多个标签下
@Controller
@RequestMapping("/hello")
public class HellolController {
    @GetMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "hello";
    }
}
