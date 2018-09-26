package com.example.docker_springboot.service.impl;

import com.example.docker_springboot.entrty.User;
import com.example.docker_springboot.mapper.UserMapper;
import com.example.docker_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public User login(String userName, String passWord) {
        User user = userMapper.login(userName, passWord);
        if (user!=null){
            redisTemplate.opsForValue().set(user.getId(),user);
            return user;
        }
        return null;
    }
}
