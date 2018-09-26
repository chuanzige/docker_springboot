package com.example.docker_springboot.service;

import com.example.docker_springboot.entrty.User;

public interface UserService {

    /**
     * 登录
     * @param userName 用户名
     * @param passWord 密码
     * @return User
     */
    User login(String userName, String passWord);
}
