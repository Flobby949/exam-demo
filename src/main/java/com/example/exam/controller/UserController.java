package com.example.exam.controller;

import com.example.exam.dto.LoginDTO;
import com.example.exam.entity.User;
import com.example.exam.service.UserService;
import com.example.exam.vo.UserLoginVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-25 17:26
 **/

@RestController
@RequestMapping("api/users")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    public UserLoginVO login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    @PostMapping("register")
    public Integer register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("logout")
    public void logout(@RequestHeader("Authorization") String token) {
        userService.logout(token);
    }
}
