package com.example.exam.controller;

import com.example.exam.service.TaskService;
import com.example.exam.vo.TaskAdminVO;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-26 13:26
 **/

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Resource
    private TaskService taskService;

    /**
     * 获取所有分配任务
     *
     * @return {@link List}<{@link TaskAdminVO}>
     */
    @GetMapping("task")
    @PreAuthorize("hasAuthority('admin')")
    public List<TaskAdminVO> getAllAssignedTask() {
        return taskService.allAssignedTask();
    }
}
