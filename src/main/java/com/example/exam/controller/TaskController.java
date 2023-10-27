package com.example.exam.controller;

import com.example.exam.dto.TaskDTO;
import com.example.exam.entity.Task;
import com.example.exam.service.TaskService;
import com.example.exam.util.TokenStoreCache;
import com.example.exam.vo.TaskVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-26 12:26
 **/

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Resource
    private TaskService taskService;
    @Resource
    private TokenStoreCache tokenStoreCache;


    /**
     * 获取全部任务
     *
     * @return {@link List}<{@link Task}>
     */
    @GetMapping()
    public List<Task> getAll() {
        return taskService.selectAll();
    }

    /**
     * 通过 ID 获取
     *
     * @return {@link Task}
     */
    @GetMapping("{id}")
    public Task getById(@PathVariable int id) {
        return taskService.selectById(id);
    }

    /**
     * 创建任务
     *
     * @param taskDTO 任务 DTO
     * @return int
     */
    @PostMapping()
    public int create(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    /**
     * 分配任务
     *
     * @param taskId 任务标识
     * @param userId 用户标识
     * @return int
     */
    @PostMapping("assign")
    public int assignTask(@RequestParam Integer taskId, @RequestParam Integer userId) {
        return taskService.assignTask(taskId, userId);
    }

    @PostMapping("complete")
    public int complete(@RequestParam Integer taskId, @RequestHeader("Authorization") String token) {
        Integer userId = tokenStoreCache.getUser(token).getId();
        return taskService.completed(userId, taskId);
    }

    /**
     * 本人被分配任务列表
     *
     * @param token  令牌
     * @return {@link List}<{@link TaskVO}>
     */
    @GetMapping("assigned")
    public List<TaskVO> assign(@RequestHeader("Authorization") String token) {
        Integer userId = tokenStoreCache.getUser(token).getId();
        return taskService.userTask(userId, false);
    }

    /**
     * 本人被分配任务列表
     *
     * @param token  令牌
     * @return {@link List}<{@link TaskVO}>
     */
    @GetMapping("completed")
    public List<TaskVO> completed(@RequestHeader("Authorization") String token) {
        Integer userId = tokenStoreCache.getUser(token).getId();
        return taskService.userTask(userId, true);
    }
}
