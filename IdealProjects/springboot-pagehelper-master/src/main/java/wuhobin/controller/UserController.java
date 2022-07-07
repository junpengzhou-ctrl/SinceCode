package wuhobin.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wuhobin.pojo.User;
import wuhobin.pojo.query.UserQuery;
import wuhobin.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model, UserQuery userQuery){
        PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
        model.addAttribute("page",userPageInfo);
        return "index";
    }

    @PostMapping("/")
    public String listUserByName(Model model,UserQuery userQuery){
        PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
        model.addAttribute("page",userPageInfo);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes){
        boolean b = userService.deleteUserById(id);
        if(b){
            attributes.addFlashAttribute("message","删除用户成功");
            return "redirect:/";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/";
        }
    }


    @GetMapping("/edit/{id}")
   public String toEdit(@PathVariable Integer id,Model model){
        model.addAttribute("user",userService.queryUserById(id));
        return "editUser";
   }


   @PostMapping("/edit")
   public String edit(User user,RedirectAttributes attributes){
       UserQuery userQuery = new UserQuery();
       Integer id = user.getId();
      userQuery.setName(user.getName());
       PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
        if(id != null){
            if(userPageInfo.getSize() == 0){
                boolean b = userService.updateUser(user);
                if(b){
                    attributes.addFlashAttribute("message"," 更新用户成功");
                    return "redirect:/";
                }else {
                    attributes.addFlashAttribute("message","更新用户失败");
                    return "redirect:/";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/edit/"+user.getId();
            }
        }else {
            if(userPageInfo.getSize() == 0){
                boolean b = userService.addUser(user);
                if(b){
                    attributes.addFlashAttribute("message"," 新增用户成功");
                    return "redirect:/";
                }else {
                    attributes.addFlashAttribute("message","新增用户失败");
                    return "redirect:/";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/";
            }
        }
   }

   @GetMapping("/update")
   public String toUpdate(Model model){
       User user = new User();
       model.addAttribute("user",user);
       return "editUser";
   }

}
