package com.sll.controller;

import com.sll.entity.User;
import com.sll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/hello")
    public String hello(Map map){

        map.put("msg","111111111111111111111");

        return "hello";

    }

    @GetMapping("/user")
    public String getAll(Map map){
        List<User> users = service.getAll();
        map.put("users",users);
        System.out.println(users);
        return "hello";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id){

        int i = service.delete(id);
        if (i>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        return "redirect:/user";

    }

    @GetMapping("/user/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Map map){

        User one = service.getOne(id);

        map.put("user",one);

        return "update";

    }

    @PutMapping("/user")
    public String update(User user){

        int i = service.update(user);
        if (i>0){
            System.out.println("编辑成功");
        }else {
            System.out.println("编辑失败");
        }

        return "redirect:/user";

    }

    @PostMapping("/user")
    public String add(User user){
        int i = service.add(user);
        if (i>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        return "redirect:/user";
    }

    @InitBinder
    public void register(WebDataBinder binder){

        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));

    }


}
