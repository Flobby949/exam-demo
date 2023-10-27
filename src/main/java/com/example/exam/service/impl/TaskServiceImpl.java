package com.example.exam.service.impl;

import com.example.exam.dto.TaskDTO;
import com.example.exam.entity.Task;
import com.example.exam.mapper.TaskMapper;
import com.example.exam.service.TaskService;
import com.example.exam.vo.TaskAdminVO;
import com.example.exam.vo.TaskVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-26 12:18
 **/

@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;

    @Override
    public int createTask(TaskDTO taskDTO) {
        return taskMapper.createNewTask(Task.builder()
                .title(taskDTO.getTitle())
                .summary(taskDTO.getDesc())
                .deadline(taskDTO.getDeadline())
                .build());
    }

    @Override
    public int assignTask(int taskId, int userId) {
        return taskMapper.assignTask(taskId, userId);
    }

    @Override
    public int completed(int userId, int taskId) {
        return taskMapper.updateTaskStatus(userId, taskId);
    }

    @Override
    public List<Task> selectAll() {
        return taskMapper.selectAll();
    }

    @Override
    public List<TaskVO> userTask(Integer userId, Boolean status) {
        return taskMapper.selectTaskByUserAndStatus(userId, status);
    }

    @Override
    public List<TaskAdminVO> allAssignedTask() {
        return taskMapper.allAssignedTask();
    }

    @Override
    public Task selectById(int id) {
        return taskMapper.selectById(id);
    }
}
