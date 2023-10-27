package com.example.exam.service;

import com.example.exam.dto.TaskDTO;
import com.example.exam.entity.Task;
import com.example.exam.vo.TaskAdminVO;
import com.example.exam.vo.TaskVO;

import java.util.List;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-26 12:18
 **/

public interface TaskService {
    int createTask(TaskDTO taskDTO);

    int assignTask(int taskId, int userId);

    int completed(int userId, int taskId);

    List<Task> selectAll();

    List<TaskVO> userTask(Integer userId, Boolean status);

    List<TaskAdminVO> allAssignedTask();

    Task selectById(int id);
}
