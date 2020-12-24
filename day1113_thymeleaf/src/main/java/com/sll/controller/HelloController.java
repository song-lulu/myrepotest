package com.sll.controller;

import com.sll.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hi")
    public String hello(Map map){
        map.put("thtext","xxxxxxxxxppppppppp");
        map.put("thtext","xxxxx<b>xxxxpppp</b>ppppp");
        map.put("thvalue","iiiiiiiiiiiiii");
        User user1 = new User(1, "kkk", 18, "nan",new Date());
        User user2 = new User(2, "小胡", 22, "nv", new Date());
        List<User> users = Arrays.asList(user1, user2);
        map.put("users",users);
        return "hello";
    }


}
