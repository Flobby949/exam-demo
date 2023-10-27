package com.example.exam.util;

import com.example.exam.security.MyUserDetails;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-26 09:04
 **/

@Component
public class TokenStoreCache {

    @Resource
    private RedisCache redisCache;

    /**
     * accessToken Key
     */
    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }

    public void saveUser(String accessToken, MyUserDetails user) {
        String key = getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public MyUserDetails getUser(String accessToken) {
        String key = getAccessTokenKey(accessToken);
        return (MyUserDetails) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}