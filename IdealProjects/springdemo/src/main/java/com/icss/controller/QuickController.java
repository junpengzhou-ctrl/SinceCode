package com.icss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //返回字符串
public class QuickController {
    @RequestMapping("/quick")
    public String Quick(){
        return "hello springboot!";
    }
}


