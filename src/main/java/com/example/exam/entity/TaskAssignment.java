package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : exam-demo
 * @description : 任务分配
 * @create : 2023-10-25 17:15
 **/

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskAssignment {
    private Integer id;
    private Integer taskId;
    private Integer userId;
    /**
     * 0-false-未完成
     * 1-true-已完成
     */
    private Boolean status;
}
