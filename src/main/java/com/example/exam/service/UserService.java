package com.example.exam.service;

import com.example.exam.dto.LoginDTO;
import com.example.exam.entity.User;
import com.example.exam.vo.UserLoginVO;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-25 17:25
 **/

public interface UserService {

    UserLoginVO login(LoginDTO loginDTO);

    int register(User user);

    void logout(String token);

    User findUserByUsername(String username);
}
