package com.puhuilink.demo.controller;

import com.puhuilink.demo.bean.User;
import com.puhuilink.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/")
    public String index(){
        return "user/list";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        return "success";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "demo运行成功";
    }
    //查询
    @GetMapping("users")
    @ResponseBody
    public String list(Model model){
        Collection<User> all = userDao.getAll();
        model.addAttribute("users",all);
        return "user/list";
    }

    @GetMapping("/user")
    public String toAddPage(Model model){
        //来到添加页面
        return "user/add";
    }

    //添加
    @PostMapping("/user")
    public String addUser(User user){
        userDao.save(user);
        return "redirect:/users";
    }

    //修改
    @PutMapping("/user/{Id}")
    public String updateUser(@PathVariable("Id") Integer id,Model model){
        User user = userDao.get(id);
        model.addAttribute("user",user);
        return "redirect:user/add";
    }

   @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userDao.delete(id);
        return "redirect:/users";
    }

}
