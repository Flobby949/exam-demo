package com.example.exam.service.impl;

import com.example.exam.dto.LoginDTO;
import com.example.exam.entity.User;
import com.example.exam.mapper.UserMapper;
import com.example.exam.security.MyUserDetails;
import com.example.exam.service.UserService;
import com.example.exam.util.TokenStoreCache;
import com.example.exam.util.TokenUtils;
import com.example.exam.vo.UserLoginVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-25 17:25
 **/

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private TokenStoreCache tokenStoreCache;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public UserLoginVO login(LoginDTO login) {
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new IllegalArgumentException("用户名或密码错误");
        }
        // 用户信息
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

        User user = userMapper.findUserByUsername(userDetails.getUsername());

        // 生成 accessToken
        String accessToken = TokenUtils.generator();
        log.info("token=========>" + accessToken);
        // 保存用户信息到缓存
        tokenStoreCache.saveUser(accessToken, userDetails);

        return UserLoginVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(accessToken)
                .build();
    }

    @Override
    public int register(User user) {
        User dbUser = userMapper.findUserByUsername(user.getUsername());
        if (dbUser != null) {
            throw new IllegalArgumentException("用户名已存在");
        }
        user.setRole("user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.insertNewUser(user);
    }

    @Override
    public void logout(String token) {
        tokenStoreCache.deleteUser(token);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
