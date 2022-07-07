package com.baifute.controller;

import com.baifute.dao.EmployeeDao;
import com.baifute.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    public EmployeeDao employeeDao;

    @RequestMapping("/emps")   //页面链接请求
    public String list(Model model){
        Collection<Employee> allEmployees = employeeDao.getAllEmployees();
        model.addAttribute("emps",allEmployees);

        return "/emp/list";    //跳转到 emp下面list.html页面
    }


}
