package com.example.docker_springboot.controller;

import com.example.docker_springboot.entrty.User;
import com.example.docker_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/login")
    public Object login(@RequestParam("username") String userName,@RequestParam("password") String passWord){
        User user = userService.login(userName, passWord);
        if(user!=null){
            Object object = redisTemplate.opsForValue().get(user.getId());
            return object;
        }
        return "用户名或密码错误";
    }
}
