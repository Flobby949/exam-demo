package com.example.exam.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.exam.entity.User;
import com.example.exam.mapper.UserMapper;
import com.example.exam.security.MyUserDetails;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-25 17:43
 **/

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByUsername(username);
        log.info("============" + user);
        if (ObjectUtil.isNull(user)) {
            log.error("用户不存在 '" + username + "'");
            throw new UsernameNotFoundException("用户不存在" + username);
        }
        return new MyUserDetails(user.getId(),
                username,
                user.getPassword(),
                user.getEmail(),
                true,
                true,
                true,
                true,
                Set.of(user.getRole())
        );
    }

}
