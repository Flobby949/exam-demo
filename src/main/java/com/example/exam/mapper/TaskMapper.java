package com.example.exam.mapper;

import com.example.exam.entity.Task;
import com.example.exam.vo.TaskAdminVO;
import com.example.exam.vo.TaskVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description :
 * @create : 2023-10-26 12:07
 **/

@Mapper
public interface TaskMapper {

    @Insert("insert into task(title, summary, deadline) VALUES (#{title}, #{summary}, #{deadline}) ")
    int createNewTask(Task task);

    @Select("select * from task ")
    List<Task> selectAll();

    @Insert("insert into task_assignment(task_id, user_id, status) value (#{taskId}, #{userId}, 0)")
    int assignTask(int taskId, int userId);

    List<TaskVO> selectTaskByUserAndStatus(@Param("userId")int userId, @Param("status") Boolean status);

    List<TaskAdminVO> allAssignedTask();

    @Select("select * from task where id = #{id}")
    Task selectById(int id);

    @Update("update task_assignment set status = 1 where user_id = #{userId} and task_id = #{taskId}")
    int updateTaskStatus(int userId, int taskId);
}
