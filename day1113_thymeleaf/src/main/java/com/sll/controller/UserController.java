package com.sll.controller;

import com.sll.entity.User;
import com.sll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/del")
    public String del(Integer id){

        service.del(id);
        return "redirect:/user/getAll";

    }

    @RequestMapping("/getAll")
    public String getAll(Map map){

        List<User> users = service.getAll();
        map.put("users",users);
        return "hello";

    }
    @RequestMapping("/update")
    public String update(Integer id,Map map){
        User one = service.getOne(id);

        map.put("one",one);

        /*map.put("id",one.getId());
        map.put("name",one.getName());
        map.put("")*/
        return "update";
    }

    @RequestMapping("/toupdate")
    public String toupdate(Integer id,String name,Integer age,String gender,String birth){

        Date birth1 = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                birth1 = sdf.parse(birth);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        User user = new User(id,name,age,gender,birth1);



        service.toupdate(user);
        System.out.println(user);
        return "redirect:/user/getAll";

    }

    @RequestMapping("/add")
    public String toadd(){
        return "add";
    }

    @RequestMapping("/toadd")
    public String add(Integer id,String name,Integer age,String gender,String birth){

        Date birth1 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birth1 = sdf.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(id,name,age,gender,birth1);

        service.add(user);
        return "redirect:/user/getAll";

    }
}
