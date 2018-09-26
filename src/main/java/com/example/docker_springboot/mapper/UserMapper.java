package com.example.docker_springboot.mapper;

import com.example.docker_springboot.entrty.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 登录
     * @param userName 用户名
     * @param passWord 密码
     * @return User
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(@Param("username") String userName, @Param("password") String passWord);


}
