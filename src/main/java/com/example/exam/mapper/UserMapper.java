package com.example.exam.mapper;

import com.example.exam.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description : mapper
 * @create : 2023-10-25 17:17
 **/

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} ")
    User findUserByUsername(String username);

    @Insert("insert into user(username, password, role, email) VALUES (#{username}, #{password}, #{role}, #{email})")
    int insertNewUser(User user);
}
