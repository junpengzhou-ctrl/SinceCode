package com.example.controller;

import com.example.pojo.User;
import com.example.pojo.queryuser.QueryUser;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model, QueryUser queryUser){
        PageInfo<User> userPageInfo = userService.getuserByName(queryUser);
        model.addAttribute("page",userPageInfo);
        return "index";
    }

    @PostMapping("/")
    public String listUserByName(Model model, QueryUser queryUser){
        PageInfo<User> userPageInfo = userService.getuserByName(queryUser);
        model.addAttribute("page",userPageInfo);
        return "index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes){
        boolean isdel = userService.deleteUser(id);
        if(isdel){
            attributes.addFlashAttribute("message","删除用户成功");
            return "redirect:/";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/";
        }
    }



    @GetMapping("/edit/{id}")
    public String toedit(@PathVariable Integer id,Model model){
        model.addAttribute("user",userService.getuserById(id));
        return "editUser";
    }

    @PostMapping("/edit")
    public String edit(User user,RedirectAttributes attributes){
        if (userService.modeUser(user)){
            attributes.addFlashAttribute("message","更新用户成功");
            return "redirect:/";
        }else {
            attributes.addFlashAttribute("message","更新用户失败");
            return "redirect:/";
        }
    }

    @GetMapping("/add")
    public String toadd(){
           return "addUser";
    }
    @PostMapping("/add")    //该用户是前端通过表单传过来的
    public String add(User user,RedirectAttributes attributes){
        //获取数据库中的id集合
        List<Integer> allId = userService.getAllId();
        if (allId.contains(user.getId())){
            attributes.addFlashAttribute("message","新增用户失败,该用户id已存在");
            return "redirect:/add";
        }else{
            boolean b = userService.addUser(user);
            if (b){
                attributes.addFlashAttribute("message","新增用户成功");
                return "redirect:/";
            }else {
                attributes.addFlashAttribute("message","新增用户失败");
                return "redirect:/";
            }
        }
    }
}
