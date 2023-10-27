package com.example.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-27 10:53
 **/

@RestController
public class TestController {

    @GetMapping("test")
    public List<String> test() {
        return List.of("1111", "22222", "333333");
    }
}
